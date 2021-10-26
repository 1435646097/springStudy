package com.paigu.interview.service;

import com.paigu.interview.entity.Book;

import java.util.List;

/**
 * 关于书的服务接口
 *
 * @author LiaoXM
 * @date 2021/09/14
 */
public interface IBookService {
	/**
	 * 得到图书列表
	 *
	 * @param test 测试
	 * @return {@link List}<{@link Book}>
	 */
	List<Book> getBookList(String test);
}
