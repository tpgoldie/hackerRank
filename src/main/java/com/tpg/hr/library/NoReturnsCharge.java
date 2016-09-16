package com.tpg.hr.library;

import java.math.BigDecimal;

public class NoReturnsCharge extends ReturnsCharge {
    public NoReturnsCharge() { super(BigDecimal.ZERO); }
}
