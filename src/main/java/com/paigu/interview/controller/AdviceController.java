package com.paigu.interview.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PaiGu
 * @description TODO
 * @date 2022/2/23 17:34
 */
@RestController
public class AdviceController {
	@GetMapping("/advice")
	public String result(){
		return "ok";
	}

	@GetMapping("/advice2")
	public Integer result2(){
		return 1;
	}
}
