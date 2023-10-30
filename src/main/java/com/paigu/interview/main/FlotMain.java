package com.paigu.interview.main;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class FlotMain {
    public static Integer i = 0;
    public static volatile Integer count = 2;

    public static Object lock = new Object();

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now.get(ChronoField.DAY_OF_MONTH));
        int dayOfMonth = now.getDayOfMonth();
        System.out.println(Instant.ofEpochSecond(3));
        System.out.println(Instant.ofEpochSecond(3,0));
        System.out.println(Instant.ofEpochSecond(2, 1_000_000_000));
        //DateUtil
        Executors.newFixedThreadPool(100);
    }

    public int streamCount(String str) {
        CountString reduce = IntStream.range(0, str.length())
                                      .parallel()
                                      .mapToObj(str::charAt)
                                      .reduce(new CountString(0, true), CountString::countWord, CountString::combine);
        return reduce.count;
    }

    public class CountString {
        private int count;
        private boolean isWhitespace;

        public CountString(int count, boolean isWhitespace) {
            this.count = count;
            this.isWhitespace = isWhitespace;
        }

        public CountString countWord(Character character) {
            if (Character.isWhitespace(character)) {
                return new CountString(this.count, true);
            } else {
                if (this.isWhitespace) return new CountString(this.count++, false);
            }
            return this;
        }

        public CountString combine(CountString wordCounter) {
            return new CountString(this.count + wordCounter.count, wordCounter.isWhitespace);
        }
    }

    public static int countWordsIteratively(String s) {
        int count = 0;
        boolean isWhitespace = false;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                //是空格直接跳过
                isWhitespace = true;
                continue;
            }
            //之前不是空格单词加1
            if (isWhitespace) count++;
            isWhitespace = false;
        }
        return count;
    }

    public Integer add() {
        int a = 20;
        int b = 30;
        int c = a + b;
        return sub();
    }

    public Integer sub() {
        int c = 10;
        return c - 5;
    }
}
