package com.paigu.interview.controller;

import com.paigu.interview.service.IPersonService;
import com.paigu.interview.utils.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author PaiGu
 * @description TODO
 * @date 2022/1/29 23:18
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/transactional")
public class TransactionalController {
	private final IPersonService personService;
	@GetMapping("/warning")
	public CommonResult transactional() throws IOException{
		personService.createPerson();
		return CommonResult.ok("成功");
	}
	@GetMapping("/fail")
	public CommonResult aopFail(){
		personService.failPerson();
		return CommonResult.ok("成功");
	}
}
