package com.tpg.hr.library;

import java.util.Calendar;
import java.util.Date;

public abstract class LibraryDate {
    private static final int ZeroDifference = 0;

    private final Date theDate;

    protected LibraryDate(int date, int month, int year) {
        this(new DateBuilder(year, month, date));
    }

    private LibraryDate(DateBuilder dateBuilder) {
        theDate = dateBuilder.build();
    }

    public boolean isBefore(LibraryDate aDate) { return theDate.before(aDate.theDate); }

    public boolean isAfter(LibraryDate aDate) { return theDate.after(aDate.theDate); }

    public boolean sameAs(LibraryDate aDate) { return theDate.compareTo(aDate.theDate) == 0; }

    public boolean hasSameMonthAs(LibraryDate aDate) { return this.getMonth() == aDate.getMonth(); }

    public boolean hasSameYearAs(LibraryDate aDate) { return this.getYear() == aDate.getYear(); }

    public int differenceInDays(LibraryDate that) {
        int difference = ZeroDifference;

        if (this.sameAs(that)) { return difference; }

        LibraryDate lhs = this;
        LibraryDate rhs = that;

        if (this.isAfter(that)) {
            lhs = that;
            rhs = this;
        }

        if (lhs.hasSameYearAs(rhs) && lhs.hasSameMonthAs(rhs)) { difference =  rhs.getDate() - lhs.getDate(); }

        return difference;
    }

    public int differenceInMonths(LibraryDate that) {
        int difference = ZeroDifference;

        if (this.sameAs(that)) { return difference; }

        LibraryDate lhs = this;
        LibraryDate rhs = that;

        if (this.isAfter(that)) {
            lhs = that;
            rhs = this;
        }

        if (lhs.hasSameYearAs(rhs) && !lhs.hasSameMonthAs(rhs)) { difference = rhs.getMonth() - lhs.getMonth(); }

        return difference;
    }

    private int getDate() { return getField(Calendar.DATE); }

    private int getMonth() { return getField(Calendar.MONTH); }

    private int getYear() { return getField(Calendar.YEAR); }

    private int getField(int field) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(theDate);
        return cal.get(field);
    }
}
