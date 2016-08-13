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

    public void start() {
        Player player = new Player(name, root);
        GameState gameState = CONTINUE;

        while(gameState == CONTINUE) {
            gameState = player.jump();

            count++;
        }
    }

    public int getJumps() { return count; }
}
