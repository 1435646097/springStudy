package com.paigu.interview.controller;

import com.paigu.interview.utils.CommonResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class JavaToolController {
	private static String A = "a";
	private static String B = "b";

	@GetMapping("/lock/dead")
	public CommonResult deadLock(){
		Thread thread1 = new Thread(()->{
			synchronized (A){
				log.info("获取了锁A");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				synchronized (B){
					log.info("获取了锁B");
				}
				log.info("释放了锁B");
			}
			log.info("释放了锁A");
		});
		Thread thread2 = new Thread(()->{
			synchronized (B){
				log.info("获取了锁A");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				synchronized (A){
					log.info("获取了锁B");
				}
				log.info("释放了锁B");
			}
			log.info("释放了锁A");
		});
		thread1.start();
		thread2.start();
		return CommonResult.ok("成功");
	}
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
		ThreadLocal<Byte[]> localVariable = new ThreadLocal<>();
		// 为线程添加变量
		localVariable.set(new Byte[4096 * 1024]);
		localVariable.remove();
		return "ok";
	}
}
