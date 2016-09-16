package com.tpg.hr.plusminus;

import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class Solution {
    private final PlusMinus plusMinus;

    public Solution(InputStream is) {
        plusMinus = PlusMinus.apply(is);
    }

    public void write(OutputStream os) {
        String pis = build(plusMinus.positiveIntegers());
        String nis = build(plusMinus.negativeIntegers());
        String zs = build(plusMinus.zeroes());

        PrintStream ps = new PrintStream(new BufferedOutputStream(os));

        ps.println(pis);
        ps.println(nis);
        ps.println(zs);
    }

    private String build(int value) {
        return String.format("%.6f", 1.0 * value / (double) plusMinus.getCount());
    }
}
