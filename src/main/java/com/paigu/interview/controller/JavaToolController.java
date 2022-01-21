package com.paigu.interview.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * java工具控制器
 *
 * @author LiaoXM
 * @date 2022/01/21
 */
@RequiredArgsConstructor
@RestController
public class JavaToolController {
	/**
	 * 模拟CPU占满
	 */
	@GetMapping("/cpu/loop")
	public void CPULoop(){
		System.out.println("请求cpu死循环");
		Thread.currentThread().setName("loop-thread-cpu");
		int num = 0;
		while (true) {
			num++;
			if (num == Integer.MAX_VALUE) {
				System.out.println("reset");
			}
			num = 0;
		}
	}
	/**
	 * 模拟内存泄漏
	 */
	@GetMapping(value = "/memory/leak")
	public String leak() {
		System.out.println("模拟内存泄漏");
		ThreadLocal<Byte[]> localVariable = new ThreadLocal<Byte[]>();
		// 为线程添加变量
		localVariable.set(new Byte[4096 * 1024]);
		return "ok";
	}
}
