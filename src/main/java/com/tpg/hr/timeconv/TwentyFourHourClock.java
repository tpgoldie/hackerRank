package com.tpg.hr.timeconv;

public class TwentyFourHourClock extends Clock {
    public TwentyFourHourClock(String input) {
        super(input);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) { return true; }

        if (!(that instanceof TwentyFourHourClock)) { return false; }

        return super.equals(that);
    }
}
