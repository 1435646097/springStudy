package com.paigu.interview.main;

import cn.hutool.core.util.RandomUtil;
import com.paigu.interview.entity.Book;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class StreamMain {
    public static void main(String[] args) {
        List<Integer> result = IntStream.rangeClosed(0, 1000)
                                        .filter(i -> i > 200)
                                        .map(i -> RandomUtil.randomInt(200, 1000))
                                        .sorted()
                                        .limit(10)
                                        .boxed()
                                        .collect(Collectors.toList());
        result.stream().count();
        List<Book> list = new ArrayList<>();
        log.info(result.toString());
    }
}
