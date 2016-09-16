package com.tpg.hr.library;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookInputReader {
    private final Scanner scanner;

    public BookInputReader(InputStream is) {
        scanner = new Scanner(is);
    }

    public List<LibraryDate> read() {
        List<LibraryDate> dates = new ArrayList<>();

        dates.add(toActualDate(scanner.nextLine()));
        dates.add(toExpectedDate(scanner.nextLine()));

        return dates;
    }

    private LibraryDate toActualDate(String input) {
        int[] tokens = toInts(input);

        return new ActualDate(tokens[0], tokens[1], tokens[2]);
    }

    private LibraryDate toExpectedDate(String input) {
        int[] tokens = toInts(input);

        return new ExpectedDate(tokens[0], tokens[1], tokens[2]);
    }

    private int[] toInts(String input) {
        int length = 3;

        int[] values = new int[length];

        String[] tokens = input.split(" ");

        for (int i = 0; i < length; i++) {
            values[i] = Integer.parseInt(tokens[i]);
        }

        return values;
    }
}
