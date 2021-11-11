package com.paigu.interview.event;

import com.paigu.interview.entity.Book;
import com.paigu.interview.service.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BookListener {
	private final IBookService bookService;

	@Async("taskExecutor")
	@EventListener(BookEvent.class)
	public void bookEvent(BookEvent bookEvent){
		Book book = (Book)bookEvent.getSource();
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getId());
		bookService.saveBook(book);
	}
}
