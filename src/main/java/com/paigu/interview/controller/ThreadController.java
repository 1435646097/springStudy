package com.paigu.interview.controller;

import com.paigu.interview.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
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
	private static  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
	Integer num = 0;

	@GetMapping
	public String countDownLatch() throws ExecutionException, InterruptedException, TimeoutException{
//		CountDownLatch countDownLatch = new CountDownLatch(100);
		List<CompletableFuture<Void>> collect = IntStream.rangeClosed(0, 99)
		                                                 .boxed()
		                                                 .map(i -> CompletableFuture.runAsync(() -> System.out.println(++num)))
		                                                 .collect(Collectors.toList());
//		countDownLatch.await(20, TimeUnit.SECONDS);
		CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(collect.toArray(new CompletableFuture[0]));
		voidCompletableFuture.get(20, TimeUnit.SECONDS);

		System.out.println("完成了");
		log.info("完成了");
		return "aaa";
	}

	@GetMapping("/dateFormat")
	public CommonResult threadLocalDateFormat(){

		for (int i = 0; i < 100; i++) {
			Thread thread = new Thread(() -> {
				for (int j = 0; j < 100; j++) {
					try {
//						log.info(dateFormat.parse("2020-01-01 11:12:13").toString());
						log.info(dateFormatThreadLocal.get().parse("2020-01-01 11:12:13").toString());
					} catch (ParseException e) {
						e.printStackTrace();
					}finally {
						dateFormatThreadLocal.remove();
					}
				}
			});
			thread.start();
		}
		return CommonResult.ok();
	}
}
