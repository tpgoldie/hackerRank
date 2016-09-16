package com.tpg.hr.library;

import java.math.BigDecimal;

public class SameMonthCharge extends ReturnsCharge {
    private static final int FIFTEEN = 15;

    public SameMonthCharge(int noOfDaysLate) { super(new BigDecimal(FIFTEEN * noOfDaysLate)); }
}
