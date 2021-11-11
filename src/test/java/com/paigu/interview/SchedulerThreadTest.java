package com.paigu.interview;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class SchedulerThreadTest {
	@Autowired
	private ApplicationContext applicationContext;
	@Test
	void scheduler() throws InterruptedException{
		ScheduledThreadPoolExecutor poolExecutor = new ScheduledThreadPoolExecutor(5, Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
		poolExecutor.schedule(() -> System.out.println("当前时间是" + System.currentTimeMillis()), 3, TimeUnit.SECONDS);
		TimeUnit.SECONDS.sleep(10);
	}
}
