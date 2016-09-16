package com.tpg.hr.library;

import java.math.BigDecimal;

public abstract class ReturnsCharge {
    private BigDecimal fine;

    protected ReturnsCharge(BigDecimal aFine) { fine = aFine; }

    public BigDecimal getFine() {
        return fine;
    }

    @Override
    public String toString() {
        return String.format("%.2f hackos", fine.doubleValue());
    }
}
