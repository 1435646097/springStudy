package com.paigu.interview.controller;

import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.JakartaServletUtil;
import com.paigu.interview.aop.cache.RedisCacheAnnotation;
import com.paigu.interview.entity.Book;
import com.paigu.interview.event.BookEvent;
import com.paigu.interview.service.IBookService;
import com.paigu.interview.utils.CommonResult;
import com.paigu.interview.utils.RedisUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


/**
 * 书本控制器
 *
 * @author LiaoXM
 * @date 2021/08/23
 */
@RestController
@Slf4j
@RedisCacheAnnotation
public class BookController {
	public BookController(@Qualifier("bookService") IBookService bookService, @Lazy ApplicationContext applicationContext, Environment environment, RedisUtils redisUtils){
		this.bookService = bookService;
		this.applicationContext = applicationContext;
		this.environment = environment;
		this.redisUtils = redisUtils;
	}

	private final IBookService bookService;
	private final ApplicationContext applicationContext;
	private final Environment environment;
	private final RedisUtils redisUtils;
	@Value("${server.port}")
	private String port;


	 @GetMapping("/increment")
	 public CommonResult increment(){
		 redisUtils.set("name", "小白");
		 return CommonResult.ok(bookService.increment());
	 }
	@GetMapping("/book")
	public CommonResult test(String test,HttpServletRequest request){
		if (StrUtil.isBlank(test)) {
			return CommonResult.fail("test必填");
		}
		log.info("GET请求参数:{}", request.getQueryString());
		return CommonResult.ok(bookService.getBookList(test));
	}

	@PostMapping("/book")
	public CommonResult createBook(@RequestBody Book book) throws InterruptedException {
		bookService.saveBook(book);
		return CommonResult.ok();
	}

	@GetMapping("/event")
	public CommonResult event(){
		applicationContext.publishEvent(new BookEvent(new Book("事件触发了")));
		return CommonResult.ok("成功了");
	}

	@GetMapping("/ip")
	public CommonResult ip(HttpServletRequest request){
		String clientIP = JakartaServletUtil.getClientIP(request);
		if ("0:0:0:0:0:0:0:1".equals(clientIP)) {
			clientIP = "127.0.0.1";
		}
		log.info("访问ip为：{}", clientIP);
		String hostAddress = NetUtil.getLocalhost().getHostAddress();
		log.info("本机ip为：{}", hostAddress);
		return CommonResult.ok(clientIP + "----" + hostAddress);
	}

	@GetMapping("/environment")
	public CommonResult environment(){
		System.out.println(environment);
		String property = environment.getProperty("rsa.private-key");
		log.info("密钥为{}", property);
		return CommonResult.ok(property);
	}

	@GetMapping("/batch-insert")
	public CommonResult batchInsert(){
		for (int i = 0; i < 10000; i++) {
			Book book = new Book();
			book.setBookName(IdUtil.simpleUUID());
			book.setBookPrice(RandomUtil.randomBigDecimal(BigDecimal.ZERO, new BigDecimal("100000")));
			bookService.save(book);
		}
		return CommonResult.ok();
	}
}
