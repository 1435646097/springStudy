package com.paigu.interview.main;

import java.time.DayOfWeek;
import java.time.temporal.*;

public class NextWorkingDay implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        int i = temporal.get(ChronoField.DAY_OF_WEEK);
        if (i == 6 || i == 7) {
            return temporal.with(TemporalAdjusters.dayOfWeekInMonth(1, DayOfWeek.MONDAY));
        }
        return temporal.plus(1, ChronoUnit.DAYS);
    }
}
