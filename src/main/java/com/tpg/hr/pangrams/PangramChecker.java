package com.tpg.hr.pangrams;

import java.util.Map;
import java.util.TreeMap;

public class PangramChecker {
    private static String TheAlphabet = "abcdefghijklmnopqrstuvwxyz";

    private final Map<Character, Boolean> all = new TreeMap();

    public PangramChecker() {
        for (int i = 0; i < TheAlphabet.length(); i++) {
            all.put(TheAlphabet.charAt(i), false);
        }
    }

    public String check(String in) {
        if (isPangram(in)) { return "pangram"; }

        return "not pangram";
    }
    private boolean isPangram(String in) {
        if (in == null) { return false; }

        boolean success = true;

        String input = in.trim().toLowerCase();

        int length = input.length();
        int i = 0;

        while (success && (i < length)) {
            Character el = input.charAt(i);
            if (Character.isLetter(el)) {
                if (!all.get(el)) {
                    all.put(el, true);
                }

                if (hasAlphabet()) {
                    return true;
                }
            }
            i++;
        }

        return hasAlphabet();
    }

    private boolean hasAlphabet() { return all.values().stream().allMatch(p -> p); }
}
