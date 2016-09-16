package com.tpg.hr.library;

import java.math.BigDecimal;

public class DifferentYearCharge extends ReturnsCharge {
    private static final int TEN_THOUSAND = 10000;

    public DifferentYearCharge() { super(new BigDecimal(TEN_THOUSAND)); }
}
