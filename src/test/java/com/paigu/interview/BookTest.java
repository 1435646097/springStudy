package com.paigu.interview;

import com.paigu.interview.FlyweightDesignPattern.BookFlyweight;
import com.paigu.interview.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class BookTest {
    @Autowired
    private BookFlyweight bookFlyweight;

    @Test
    void bookFlyweight() {
        Book book1 = new Book("我的", BigDecimal.valueOf(33.33));
        Book book2 = new Book("他的", BigDecimal.valueOf(32.33));
        Book book3 = new Book("我的", BigDecimal.valueOf(31.33));
        Book book4 = new Book("你的", BigDecimal.valueOf(33.33));
        Book book5 = new Book("我的", BigDecimal.valueOf(33.33));
        bookFlyweight.put(book1);
        bookFlyweight.put(book2);
        bookFlyweight.put(book3);
        bookFlyweight.put(book4);
        bookFlyweight.put(book5);
        BigDecimal reduce = bookFlyweight.bookHashMap.values()
                                                     .stream()
                                                     .map(Book::getBookPrice)
                                                     .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(reduce);
    }
}
