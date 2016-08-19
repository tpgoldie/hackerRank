package com.tpg.hr.clouds;

import java.util.Optional;

import static com.tpg.hr.clouds.GameState.CONTINUE;
import static com.tpg.hr.clouds.GameState.LOSE;
import static com.tpg.hr.clouds.GameState.WIN;

public class Player {
    private final String name;

    private int count = 0;

    private Optional<Cloud> cloud;

    public Player(String name, Optional<Cloud> cloud) {
        this.name = name;
        this.cloud = cloud;
    }

    public GameState jump() {
        if (hasLeft(this.cloud)) {
            this.cloud = cloud.map(c -> c.getLeft().get());
            count++;

            if (this.cloud.map(c -> c instanceof ThunderCloud).get()) { return LOSE; }
            return CONTINUE;
        }

        return WIN;
    }

    public int getJumps() { return count; }

    private boolean hasLeft(Optional<Cloud> cloud) {
        if (!cloud.isPresent()) { return false; }
        if (!cloud.map(c -> c.getLeft().isPresent()).get()) { return false; }
        return true;
    }

    private boolean hasRight(Optional<Cloud> cloud) {
        if (!cloud.isPresent()) { return false; }
        if (!cloud.map(c -> c.getRight().isPresent()).get()) { return false; }
        return true;
    }
}
