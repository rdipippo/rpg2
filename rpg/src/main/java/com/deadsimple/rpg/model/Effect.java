package com.deadsimple.rpg.model;

public interface Effect {
    GameState apply(GameState gs);

    GameState unapply(GameState gs);
}
