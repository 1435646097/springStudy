package com.paigu.interview;

import com.paigu.interview.Enum.SingletonEnum;
import com.paigu.interview.entity.Book;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class EnumTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(SingletonEnum.instance.getName());
        System.out.println(SingletonEnum.person.getName());
        System.out.println();
        SingletonEnum.student.setName("起飞");
        System.out.println(SingletonEnum.student.getName());
        HashMap<String, String> map = new HashMap<>();
        DateFormat dateInstance = DateFormat.getDateInstance();
        LocalDateTime now = LocalDateTime.now();
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);
        HashMap<Integer, Book> bookHashMap = new HashMap<>();
        bookHashMap.put(1, new Book("红楼梦", new BigDecimal("300")));
        bookHashMap.put(2, new Book("水浒传", new BigDecimal("300")));
        bookHashMap.put(3, new Book("西游记", new BigDecimal("300")));
        HashMap<Integer, Book> bookHashMap1 = (HashMap<Integer, Book>)bookHashMap.clone();
        bookHashMap1.put(2, new Book("我已经修改好了", new BigDecimal("300")));
        bookHashMap1.remove(2);
        System.out.println(bookHashMap);
        System.out.println(bookHashMap1);
        System.out.println("------开始测试-------");
        test(bookHashMap);
        System.out.println(bookHashMap);

        Book b1 = new Book("我的世界");
        Book b2 = new Book("迷你世界");
        swap(b1,b2);
        System.out.println(b1.getBookName());
        System.out.println(b2.getBookName());
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.lockInterruptibly();
        Thread.currentThread().interrupt();
        if (reentrantLock.isHeldByCurrentThread()) {

        }
        try {
        } finally {
            reentrantLock.unlock();
        }
        RedissonClient client = Redisson.create();
        client.getLock()
    }

    public static void swap(Book b1, Book b2) {
       Book temp = b1;
       b1 = b2;
       b2 = temp;
       System.out.println(b1.getBookName());
       System.out.println(b2.getBookName());
    }

    public static void test(HashMap<Integer,Book> bookHashMap){
        bookHashMap.remove(1);
        System.out.println(bookHashMap);
    }
}
