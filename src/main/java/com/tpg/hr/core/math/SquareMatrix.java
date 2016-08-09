package com.tpg.hr.core.math;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SquareMatrix {
    public static SquareMatrix apply(InputStream is) {
        InputReader reader = new InputReader(is);
        return reader.getMatrix();
    }

    private final int size;

    private final int[][] data;

    public SquareMatrix(int size) {
        this.size = size;
        this.data = new int[size][size];
    }

    public void addRow(int r, List<Integer> row) {
        for (int i = 0; i < size; i++) {
            data[r][i] = row.get(i);
        }
    }

    public int getSize() {
        return size;
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

    static class InputReader {
        private final Scanner scanner;

        private final int size;

        private SquareMatrix matrix;

        public InputReader(InputStream is) {
            this.scanner = new Scanner(is);
            size = scanner.nextInt();

            matrix = new SquareMatrix(size);

            int r = 0;

            List<Integer> row = null;

            while (scanner.hasNext() || scanner.hasNextLine()) {
                row = getRow();
                matrix.addRow(r++, row);
            }

             while(r < size) {
                 matrix.addRow(r++, row);
             }
        }

        private List<Integer> getRow() {
            List<Integer> row = new ArrayList();

            for (int i = 0; i < size; i++) {
                row.add(scanner.nextInt());
            }

            return row;
        }

        public int getSize() {
            return size;
        }

        public SquareMatrix getMatrix() {
            return matrix;
        }
    }
}
