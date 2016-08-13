package com.tpg.hr.clouds;

import java.util.Optional;

public abstract class Cloud {
    protected final Optional<Cloud> left;
    protected final Optional<Cloud> right;

    protected Cloud(Optional<Cloud> lhs, Optional<Cloud> rhs) {
        left = lhs;
        right = rhs;
    }

    public Optional<Cloud> getLeft() {
        return left;
    }

    public Optional<Cloud> getRight() {
        return right;
    }
}
