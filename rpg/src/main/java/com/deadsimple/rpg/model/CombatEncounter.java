package com.deadsimple.rpg.model;

public class CombatEncounter extends Encounter {
    Opponent opponent;

    public Opponent getOpponent() {
        return opponent;
    }

    public void setOpponent(Opponent opponent) {
        this.opponent = opponent;
    }

    @Override
    public GameState run(GameState gs) {
        return null;
    }

    @Override
    public GameState processPlayerAction(GameState gs) {
        return null;
    }
}
