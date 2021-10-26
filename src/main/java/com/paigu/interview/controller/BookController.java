package com.paigu.interview.controller;

import cn.hutool.core.util.StrUtil;
import com.paigu.interview.service.IBookService;
import com.paigu.interview.utils.CommonResult;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 书本控制器
 *
 * @author LiaoXM
 * @date 2021/08/23
 */
@RestController
public class BookController {
	public BookController(@Qualifier("bookService") IBookService bookService){
		this.bookService = bookService;
	}

	private IBookService bookService;
	@Value("${server.port}")
	private String port;

	@GetMapping("/pro/test")
	public CommonResult test(String test){
		if (StrUtil.isBlank(test)) {
			return CommonResult.fail("test必填");
		}
		return CommonResult.ok(bookService.getBookList(test));
	}
}
