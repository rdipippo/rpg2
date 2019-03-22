package com.deadsimple.rpg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Opponent implements Combatant {
    @Id
    String id;

    GameField attack;

    GameField defense;

    GameField health;

    String name;

    Range weaponDamage;

    public Opponent() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GameField getAttack() {
        return attack;
    }

    public void setAttack(GameField attack) {
        this.attack = attack;
    }

    public GameField getDefense() {
        return defense;
    }

    public void setDefense(GameField defense) {
        this.defense = defense;
    }

    public GameField getHealth() {
        return health;
    }

    public void setHealth(GameField health) {
        this.health = health;
    }

    @Override
    public Range getWeaponDamage() {
        return weaponDamage;
    }

    @Override
    public void setWeaponDamage(Range weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
