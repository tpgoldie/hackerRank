package com.tpg.hr.library;

import java.util.Calendar;
import java.util.Date;

public class DateBuilder {
    private final int year;
    private final int month;
    private final int date;

    public DateBuilder(int year, int month, int date) {
        assertThat(1, year, 3000);
        assertThat(Calendar.JANUARY, month-1, Calendar.DECEMBER);
        assertThat(1, date, 31);

        this.year = year;
        this.month = month - 1;
        this.date = date;
    }

    private void assertThat(int lowerBound, int value, int upperBound) {
        if ((value < lowerBound) || (value > upperBound)) {
            String msg = String.format("%d < %d or %d > %d", value, lowerBound, value, upperBound);
            throw new RuntimeException(msg);
        }
    }

    public Date build() {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, date);
        return cal.getTime();
    }
}
