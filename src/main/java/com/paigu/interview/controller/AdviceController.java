package com.paigu.interview.controller;

import com.paigu.interview.aop.cache.RedisCacheAnnotation;
import com.paigu.interview.service.IPersonService;
import com.paigu.interview.utils.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PaiGu
 * @description TODO
 * @date 2022/2/23 17:34
 */
@RequiredArgsConstructor
@RestController
public class AdviceController {
	private final IPersonService personService;

	@GetMapping("/advice")
	public String result(){
		return "ok";
	}

	@RedisCacheAnnotation
	@GetMapping("/advice2")
	public CommonResult result2(){
//		Person person = personService.getById(1494570401353904130L);
//		Book book = new Book();
//		book.setBookName("啊12312啊啊啊啊啊2312啊");
//		person.setBook(book);
//		List<Person> list = personService.list();
		System.out.println("");
		List<String> list1 = new ArrayList<>();
		return CommonResult.ok(list1);
	}

	@RedisCacheAnnotation
	@PostMapping("/advice2")
	public CommonResult result3(){
//		Person person = personService.getById(1494570401353904130L);
//		Book book = new Book();
//		book.setBookName("啊12312啊啊啊啊啊2312啊");
//		person.setBook(book);
//		List<Person> list = personService.list();
		System.out.println("");
		List<String> list1 = new ArrayList<>();
		return CommonResult.ok(list1);
	}
}
