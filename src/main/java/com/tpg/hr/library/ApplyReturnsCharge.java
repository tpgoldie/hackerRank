package com.tpg.hr.library;

public class ApplyReturnsCharge {
    private final ActualDate actualDate;

    private final ExpectedDate expectedDate;

    public ApplyReturnsCharge(ActualDate actualDate, ExpectedDate expectedDate) {
        this.actualDate = actualDate;
        this.expectedDate = expectedDate;
    }

    public ReturnsCharge getCharge() {
        if (actualDate.isBefore(expectedDate) || actualDate.sameAs(expectedDate)) { return new NoReturnsCharge(); }

        if (actualDate.isAfter(expectedDate) && actualDate.hasSameMonthAs(expectedDate) &&
            actualDate.hasSameYearAs(expectedDate)) { return new SameMonthCharge(actualDate.differenceInDays(expectedDate)); }

        if (actualDate.hasSameYearAs(expectedDate)) { return new DifferentMonthCharge(actualDate.differenceInMonths(expectedDate)); }

        return new DifferentYearCharge();
    }
}
