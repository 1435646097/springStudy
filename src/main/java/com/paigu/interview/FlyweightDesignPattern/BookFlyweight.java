package com.paigu.interview.FlyweightDesignPattern;

import com.paigu.interview.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 书(享元)
 *
 * @author LiaoXM
 * @date 2021/11/01
 */
@Component
@Slf4j
public class BookFlyweight implements InitializingBean {
   public HashMap<Integer, Book> bookHashMap;

	@Override
	public void afterPropertiesSet(){
		bookHashMap = new HashMap<>(10);
	}

	public Book put(Book book){
		int hashCode = book.hashCode();
		if (bookHashMap.containsKey(hashCode)) {
			log.info("book size {}",bookHashMap.size());
			return bookHashMap.get(hashCode);
		}
		bookHashMap.put(hashCode, book);
		log.info("book size {}",bookHashMap.size());
		return book;
	}
}
