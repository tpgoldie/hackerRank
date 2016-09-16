package com.tpg.hr.library;

import java.io.*;
import java.util.List;

public class Solution {
    private final BookInputReader reader;

    public Solution(InputStream is) {
        reader = new BookInputReader(is);
    }

    public int solve() {
        List<LibraryDate> dates = reader.read();
        ActualDate actualDate = (ActualDate) dates.get(0);
        ExpectedDate expectedDate = (ExpectedDate) dates.get(1);

        ReturnsCharge charge = new ApplyReturnsCharge(actualDate, expectedDate).getCharge();
        return charge.getFine().intValue();
    }
}
