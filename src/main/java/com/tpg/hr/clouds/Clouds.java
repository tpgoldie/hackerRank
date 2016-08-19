package com.tpg.hr.clouds;

import java.util.Optional;

import static com.tpg.hr.clouds.GameState.CONTINUE;

public class Clouds {
    private final Optional<Cloud> root;
    private final String name;
    private int count;

    public Clouds(String name, Optional<Cloud> root) {
        this.root = root;
        this.name = name;
    }

    public GameState play() {
        Player player = new Player(name, root);
        GameState gameState = CONTINUE;

        while (gameState == CONTINUE) {
            gameState = player.jump();
            count = player.getJumps();
        }

        return gameState;
    }

    public int getJumps() { return count; }
}
