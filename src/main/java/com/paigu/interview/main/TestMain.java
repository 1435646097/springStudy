package com.paigu.interview.main;

import com.paigu.interview.entity.Book;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestMain {
    static Integer num = 0;

    public static void main(String[] args) throws InterruptedException {
        Stream<Integer> integerStream = Stream.of(2, 3, 4, 5, 4, 3, 3);
        Optional<Integer> max = integerStream.max(Integer::compareTo);
        System.out.println(max.get());
        IntStream.rangeClosed(1, 20)
                 .forEach(s -> {
                     Thread thread = new Thread(() -> System.out.println(s));
                     thread.start();
                 });
        List<Book> list = new ArrayList<>();
        list.add(new Book("水浒传", new BigDecimal("212.22")));
        list.add(new Book("红楼梦", new BigDecimal("232.22")));
        list.add(new Book("水浒传", new BigDecimal("522.22")));
        list.add(new Book("红楼梦", new BigDecimal("232.22")));
        list.add(new Book("三国演绎", new BigDecimal("2322.22")));
        list.stream()
                                .collect(Collectors.groupingBy(Book::getBookName))
                                .values().forEach(System.out::println);
    }
}
