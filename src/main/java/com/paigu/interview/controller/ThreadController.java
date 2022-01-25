package com.paigu.interview.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 线程控制器
 *
 * @author LiaoXM
 * @date 2022/01/25
 */
@Slf4j
@RestController
@RequestMapping("/thread")
public class ThreadController {
	Integer num = 0;
	@GetMapping
	public String countDownLatch(){
//		CountDownLatch countDownLatch = new CountDownLatch(100);
		List<CompletableFuture<Void>> collect = IntStream.rangeClosed(0, 99)
		                                                 .boxed()
		                                                 .map(i -> CompletableFuture.runAsync(() -> System.out.println(++num)))
		                                                 .collect(Collectors.toList());
//		countDownLatch.await(20, TimeUnit.SECONDS);
		CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(collect.toArray(new CompletableFuture[0]));
		voidCompletableFuture.join();
		System.out.println("完成了");
		log.info("完成了");
		return "aaa";
	}
}
