package com.tpg.hr.timeconv;

import java.util.Optional;

import static com.tpg.hr.timeconv.TwelveHourSuffix.apply;

public class TimeConverter {
    public String convert(String in) { return convert(new TwelveHourClock(in)).toString(); }

    private TwentyFourHourClock convert(TwelveHourClock in) {
        Optional<TwelveHourSuffix> suffix = apply(in.getSuffix());
        String hour = in.hh;

        if (suffix.get().equals(TwelveHourSuffix.AM)) {
            if (hour.equals("12")) { hour = "00"; }
        }
        else if (suffix.get().equals(TwelveHourSuffix.PM)) {
            int t = Integer.parseInt(hour.substring(0, 1));

            int u = Integer.parseInt(hour.substring(1, 2));

            int hh = ((t == 1) && (u == 2)) ?  12 : 12 + t * 10 + u;
            hour = String.valueOf(hh);
        }

        String input = String.format("%s:%s:%s", hour, in.getMm(), in.getSs());

        return new TwentyFourHourClock(input);
    }
}
