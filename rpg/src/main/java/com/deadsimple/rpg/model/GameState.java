package com.deadsimple.rpg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
public class GameState implements Serializable {
    @Id
    String id;

    int level;

    int health;

    int attack;

    int defense;

    @DBRef
    PlayerClass playerClass;

    @Transient
    public static GameState initNewPlayer() {
        GameState newGS = new GameState();
        newGS.setLevel(1);
        newGS.setHealth(10);
        newGS.setAttack(10);
        newGS.setDefense(10);
        return newGS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PlayerClass getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(PlayerClass playerClass) {
        this.playerClass = playerClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
