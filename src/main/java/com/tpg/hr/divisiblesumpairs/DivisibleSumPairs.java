package com.tpg.hr.divisiblesumpairs;

public class DivisibleSumPairs {
    private final int k;
    private final int[] input;
    private int count = 0;

    public DivisibleSumPairs(int[] input, int k) {
        this.k = k;

        if (input == null) { this.input = new int[0]; }
        else { this.input = input; }
    }

    Pair pair(int i, int j) { return new Pair(input[i], input[j]); }

    int count() {
        int size = input.length;

        if (size == 0) { return size; }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row < col) {
                    Pair pair = pair(row, col);
                    if (pair.isDivisibleBy(k)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
