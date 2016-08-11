package com.tpg.hr.marsexpl;

public class AlteredMessages {
    private static final String SOS = "SOS";

    private final String input;

    public AlteredMessages(String input) {
        this.input = input;
    }

    public int getValue() {
        int size = input.length();
        int dividend = SOS.length();
        int count = size / dividend;

        int number = 0;

        for (int i = 0; i < count; i++) {
            String temp = input.substring(i * dividend, (i+1) * dividend);
            if (!temp.equalsIgnoreCase(SOS)) {
                number += matches(temp, SOS);
            }
        }

        return number;
    }

    private int matches(String lhs, String rhs) {
        int length = lhs.length();
        int count = 0;

        if (lhs.length() == rhs.length()) {

            for (int i = 0; i < length; i++) {
                if (lhs.charAt(i) != rhs.charAt(i)) { count++; }
            }
        }

        return count;
    }
}
