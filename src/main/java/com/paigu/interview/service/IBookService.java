package com.paigu.interview.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.paigu.interview.entity.Book;

import java.util.List;

/**
 * 关于书的服务接口
 *
 * @author LiaoXM
 * @date 2021/09/14
 */
public interface IBookService extends IService<Book> {
	/**
	 * 得到图书列表
	 *
	 * @param test 测试
	 * @return {@link List}<{@link Book}>
	 */
	List<Book> getBookList(String test);

	/**
	 * 保存的书
	 *
	 * @param book 书
	 */
	void saveBook(Book book) throws InterruptedException;
}
