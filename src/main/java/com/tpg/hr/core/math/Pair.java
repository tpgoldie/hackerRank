package com.tpg.hr.core.math;

public class Pair<T, U> {
    private final T left;
    private final U right;

    public Pair(T left, U right) {
        this.left = left;
        this.right = right;
    }

    public T getLeft() {
        return left;
    }

    public U getRight() {
        return right;
    }

    public boolean isTheSame() {
        return left.equals(right);
    }
}
