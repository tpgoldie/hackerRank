package com.tpg.hr.diagdiff;

import java.util.Arrays;
import java.util.List;

public class SquareMatrix {
    private int size;

    private int[][] data;

    public SquareMatrix(int size) {
        this.size = size;
        data = new int[size][size];
    }

    public void addRow(int r, List<Integer> row) {
        for (int i = 0; i < size; i++) {
            data[r][i] = row.get(i);
        }
    }

    public int getMainDiagonalSum() {
        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += data[i][i];
        }

        return sum;
    }

    public int getSecondaryDiagonalSum() {
        int sum = 0;

        int r = 0;

        for (int c = (size-1); c > -1; c--) {
            sum += data[r++][c];
        }

        return sum;
    }

    public boolean equals(Object that) {
        if (that == this) { return true; }
        if (!(that instanceof SquareMatrix)) { return false; }

        SquareMatrix other = (SquareMatrix) that;

        if (other.size != this.size) { return false; }

        for (int r = 0; r < size; r++) {
            if (!Arrays.equals(other.data[r], this.data[r])) { return false; }
        }

        return true;
    }

    public int hashCode() {
        int result = 37;

        result = result * 31 + size;
        for (int r = 0; r < size; r++) {
            result = result * 31 + data[r].hashCode();
        }

        return result;
    }
}
