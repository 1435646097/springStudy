package com.paigu.interview.service.impl;

import cn.hutool.http.HttpUtil;
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

	private static List<Book> list = new ArrayList<>();

	@Override
	@redisCacheAnnotation(expire = 300)
	@Cacheable(value = {"aaaa", "111"}, key = "#test")
	public List<Book> getBookList(String test){
		redisUtils.set("111", "222");
		list.add(new Book("好看的书"));
		HttpUtil.get("asd");
		return list;
	}
}
