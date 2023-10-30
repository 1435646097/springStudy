package com.paigu.interview.main;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateMain {
    public static void main(String[] args) {
        LocalDate now = LocalDate.of(2023, 9, 5);
        LocalDate nextWorkingDay = now.with(nowDate -> {
            int i = nowDate.get(ChronoField.DAY_OF_WEEK);
            if (i == 6 || i == 7) {
                return nowDate.with(TemporalAdjusters.dayOfWeekInMonth(1, DayOfWeek.MONDAY));
            }
            return nowDate.plus(1, ChronoUnit.DAYS);
        });
        System.out.println(nextWorkingDay);
        DateUtil.format(new Date(), DatePattern.NORM_DATETIME_FORMAT);
    }
}
