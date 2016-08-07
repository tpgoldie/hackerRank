package com.tpg.hr.divisiblesumpairs;

public class Pair {
    private final int left;
    private final int right;

    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public boolean isDivisibleBy(int k) {
        return isDivisibleBy(left + right, k);
    }

    private boolean isDivisibleBy(int dividend, int divisor) {
        if (divisor == 0) { return false; }
        return (dividend % divisor) == 0;
    }

    public boolean equals(Object that) {
        if (that == this) { return true; }
        if (!(that instanceof Pair)) { return false; }

        Pair other = (Pair) that;
        return ((other.left == this.left) && (other.right == this.right));
    }

    public int hashCode() {
        int result = 31;
        result = 37 * result + left;
        result = 37 * result + right;
        return result;
    }

    public String toString() { return String.format("(%d, %d)", left, right); }
}
