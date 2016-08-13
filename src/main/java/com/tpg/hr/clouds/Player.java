package com.tpg.hr.clouds;

import java.util.Optional;

import static com.tpg.hr.clouds.GameState.CONTINUE;
import static com.tpg.hr.clouds.GameState.END;

public class Player {
    private final String name;

    private Optional<Cloud> cloud;

    public Player(String name, Optional<Cloud> cloud) {
        this.name = name;
        this.cloud = cloud;
    }

    public GameState jump() {
        if (this.cloud.map(c -> c.getLeft().isPresent()).get()) {
            this.cloud = cloud.map(c -> c.getLeft().get());
            if (this.cloud.map(c -> c instanceof ThunderCloud).get()) { return END; }
            return CONTINUE;
        }

        return END;
    }
}
