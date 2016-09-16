package com.tpg.hr.plusminus;

import java.io.InputStream;
import java.util.Scanner;

public class PlusMinus {
    public static PlusMinus apply(InputStream is) {
        InputReader reader = new InputReader(is);
        return reader.plusMinus();
    }

    private static final int Zero = 0;

    private final int[] values;
    private int count = 0;
    private int positiveIntegers = 0;
    private int negativeIntegers = 0;
    private int zeroes = 0;

    PlusMinus(int size) {
        values = new int[size];
    }

    void add(int value) {
        if (count >= values.length) { return; }

        values[count++] = value;
        if (value > Zero) { positiveIntegers++; }
        if (value < Zero) { negativeIntegers++; }
        if (value == Zero) { zeroes++; }
    }

    public int positiveIntegers() { return positiveIntegers; }

    public int negativeIntegers() { return negativeIntegers; }

    public int zeroes() { return zeroes; }

    public int getCount() { return values.length; }

    static class InputReader {
        private final Scanner scanner;

        private final PlusMinus plusMinus;

        public InputReader(InputStream is) {
            scanner = new Scanner(is);
            int size = scanner.nextInt();

            plusMinus = new PlusMinus(size);

            while (scanner.hasNext() || scanner.hasNextLine()) {
                plusMinus.add(scanner.nextInt());
            }
        }

        public PlusMinus plusMinus() {
            return plusMinus;
        }
    }
}
