package com.tpg.hr.library;

import java.math.BigDecimal;

public class DifferentMonthCharge extends ReturnsCharge {
    private static final int FIVE_HUNDRED = 500;

    public DifferentMonthCharge(int noOfMonthsLate) { super(new BigDecimal(FIVE_HUNDRED * noOfMonthsLate)); }
}
