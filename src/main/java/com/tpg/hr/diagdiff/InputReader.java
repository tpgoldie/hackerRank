package com.tpg.hr.diagdiff;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {
    private final Scanner in;

    private int matrixSize;

    private SquareMatrix matrix;

    public InputReader(InputStream is) {
        this.in = new Scanner(is);
        matrixSize = in.nextInt();

        matrix = new SquareMatrix(matrixSize);

        for (int r = 0; r < matrixSize; r++) {
            matrix.addRow(r, getRow());
        }
    }

    private List<Integer> getRow() {
        List<Integer> row = new ArrayList();

        for (int i = 0; i < matrixSize; i++) {
            row.add(in.nextInt());
        }

        return row;
    }

    public int getMatrixSize() {
        return matrixSize;
    }

    public SquareMatrix getMatrix() {
        return matrix;
    }
}
