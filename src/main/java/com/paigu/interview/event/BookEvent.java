package com.paigu.interview.event;

import com.paigu.interview.entity.Book;
import org.springframework.context.ApplicationEvent;

/**
 * 书事件
 *
 * @author LiaoXM
 * @date 2021/11/11
 */
public class BookEvent extends ApplicationEvent {
	public BookEvent(Book book){
		super(book);
	}
}
