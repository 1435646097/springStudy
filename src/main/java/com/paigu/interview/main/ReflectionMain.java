package com.paigu.interview.main;

import com.paigu.interview.entity.Book;
import lombok.SneakyThrows;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

/**
 * 反射主要类
 *
 * @author LiaoXM
 * @date 2022/02/17
 */
public class ReflectionMain {
	@SneakyThrows
	public static void main(String[] args) throws Exception{
		Book book = new Book();
//		book.price(30);
//		book.price(Integer.valueOf(30));
		Class.forName("com.paigu.interview.entity.Book").getDeclaredMethod("price", Integer.TYPE).invoke(book, 30);
		Book.class.getDeclaredMethod("price", Integer.class).invoke(book, 30);
		Book.class.getDeclaredMethod("price", Integer.class).invoke(book, 30);
		Instant start = Instant.now();
		TimeUnit.SECONDS.sleep(1);
		System.out.println(ChronoUnit.MILLIS.between(start, Instant.now()));
		System.out.println(Duration.between(start, Instant.now()).toMillis());
	}
}
