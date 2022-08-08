package com.paigu.interview.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.paigu.interview.aop.cache.RedisCacheAnnotation;
import com.paigu.interview.entity.Book;
import com.paigu.interview.mapper.BookMapper;
import com.paigu.interview.service.IBookService;
import com.paigu.interview.utils.RedisUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 书服务实现
 *
 * @author LiaoXM
 * @date 2021/09/14
 */
@Service("bookService")
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
    private final RedisUtils redisUtils;

    public BookServiceImpl(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    private static final List<Book> LIST = new ArrayList<>();

    @Override
    @RedisCacheAnnotation(expire = 300)
    @Cacheable(value = {"aaaa", "111"}, key = "#test")
    public List<Book> getBookList(String test) {
        return this.list();
    }

    @Override
    @Transactional
    public void saveBook(Book book) {
        save(book);
        try {
            Thread.sleep(20000);
        } catch (Exception e) {
            log.error("报错了");
        }
    }
}
