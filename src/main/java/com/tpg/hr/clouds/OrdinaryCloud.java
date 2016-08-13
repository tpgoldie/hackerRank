package com.tpg.hr.clouds;

import java.util.Optional;

import static java.util.Optional.empty;

public class OrdinaryCloud extends Cloud {
    public OrdinaryCloud() {
        this(empty(), empty());
    }

    public OrdinaryCloud(Optional<Cloud> lhs) {
        super(lhs, empty());
    }

    public OrdinaryCloud(Optional<Cloud> lhs, Optional<Cloud> rhs) {
        super(lhs, rhs);
    }
}
