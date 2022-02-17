package com.paigu.interview.main;

import com.paigu.interview.entity.Book;
import lombok.SneakyThrows;

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
	}
}
