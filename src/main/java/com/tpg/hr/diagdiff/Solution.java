package com.tpg.hr.diagdiff;

import com.tpg.hr.core.math.SquareMatrix;

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        SquareMatrix matrix = SquareMatrix.apply(System.in);
        int diff = Math.abs(matrix.getMainDiagonalSum() - matrix.getSecondaryDiagonalSum());
        System.out.println(diff);
    }
}