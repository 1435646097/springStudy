package com.paigu.interview.controller;

import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import com.paigu.interview.entity.Book;
import com.paigu.interview.event.BookEvent;
import com.paigu.interview.service.IBookService;
import com.paigu.interview.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * 书本控制器
 *
 * @author LiaoXM
 * @date 2021/08/23
 */
@RestController
@Slf4j
public class BookController {
	public BookController(@Qualifier("bookService") IBookService bookService, ApplicationContext applicationContext, Environment environment){
		this.bookService = bookService;
		this.applicationContext = applicationContext;
		this.environment = environment;
	}

	private final IBookService bookService;
	private final ApplicationContext applicationContext;
	private final Environment environment;
	@Value("${server.port}")
	private String port;

	@GetMapping("/pro/test")
	public CommonResult test(String test,HttpServletRequest request){
		if (StrUtil.isBlank(test)) {
			return CommonResult.fail("test必填");
		}
		return CommonResult.ok(bookService.getBookList(test));
	}

	@GetMapping("/event")
	public CommonResult event(){
		applicationContext.publishEvent(new BookEvent(new Book("事件触发了")));
		return CommonResult.ok("成功了");
	}

	@GetMapping("ip")
	public CommonResult ip(HttpServletRequest request){
		String clientIP = ServletUtil.getClientIP(request);
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
}
