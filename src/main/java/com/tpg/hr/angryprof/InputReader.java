package com.tpg.hr.angryprof;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {
    private final Scanner in;

    private final int numberOfTests;

    public InputReader(InputStream is) {
        in = new Scanner(is);
        numberOfTests = in.nextInt();
    }

    public int getNumberOfTestCases() {
        return numberOfTests;
    }

    public List<TestCase> getTestCases() {
        List<TestCase> testCases = new ArrayList<>(numberOfTests);

        for (int i = 0; i < numberOfTests; i++) {
            int N = in.nextInt();
            testCases.add(new TestCase(N, in.nextInt(), readTestData(N)));
        }

        return testCases;
    }

    private Integer[] readTestData(int n) {
        Integer[] testData = new Integer[n];

        for (int i = 0; i < n; i++) {
            testData[i] = in.nextInt();
        }

        return testData;
    }
}
