package com.tpg.hr.timeconv;

public class TwelveHourClock extends Clock {
    public TwelveHourClock(String input) {
        super(input);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) { return true; }

        if (!(that instanceof TwelveHourClock)) { return false; }

        return super.equals(that);
    }
}
