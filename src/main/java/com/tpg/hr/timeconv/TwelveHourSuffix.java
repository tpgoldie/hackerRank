package com.tpg.hr.timeconv;

import java.util.Optional;

public enum TwelveHourSuffix {
    AM("AM"), PM("PM");

    private final String value;

    public static Optional<TwelveHourSuffix> apply(String input) {
        if (AM.name().equals(input.toUpperCase())) { return Optional.of(AM); }
        if (PM.name().equals(input.toUpperCase())) { return Optional.of(PM); }
        return Optional.empty();
    }

    TwelveHourSuffix(String value) {
        this.value = value;
    }
}
