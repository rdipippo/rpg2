package com.deadsimple.rpg.model;

public interface Combatant {
    GameField getAttack();

    void setAttack(GameField attack);

    GameField getDefense();

    void setDefense(GameField defense);

    GameField getHealth();

    void setHealth(GameField health);
}
