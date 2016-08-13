package com.tpg.hr.clouds;

import java.util.Optional;

import static java.util.Optional.empty;

public class ThunderCloud extends Cloud {
    public ThunderCloud(Optional<Cloud> lhs) {
        this(lhs, empty());
    }

    public ThunderCloud(Optional<Cloud> lhs,Optional<Cloud> rhs) {
        super(lhs, rhs);
    }
}
