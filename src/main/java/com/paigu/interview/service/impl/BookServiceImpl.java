package com.paigu.interview.service.impl;

import com.paigu.interview.aop.cache.redisCacheAnnotation;
import com.paigu.interview.entity.Book;
import com.paigu.interview.service.IBookService;
import com.paigu.interview.utils.RedisUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 书服务实现
 *
 * @author LiaoXM
 * @date 2021/09/14
 */
@Service("bookService")
public class BookServiceImpl implements IBookService {
	private final RedisUtils redisUtils;

	public BookServiceImpl(RedisUtils redisUtils){
		this.redisUtils = redisUtils;
	}

	private static final List<Book> LIST = new ArrayList<>();

	@Override
	@redisCacheAnnotation(expire = 300)
	@Cacheable(value = {"aaaa", "111"}, key = "#test")
	public List<Book> getBookList(String test){
		redisUtils.set("111", "222");
		LIST.add(new Book("好看的书"));
		return LIST;
	}

	@Override
	public void saveBook(Book book){
		System.out.println(book);
		System.out.println("成功保存一本书");
	}
}
