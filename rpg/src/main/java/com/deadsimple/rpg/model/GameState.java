package com.deadsimple.rpg.model;

import com.deadsimple.rpg.model.embedded.Message;
import com.deadsimple.rpg.repository.OpponentRepository;
import com.mongodb.BasicDBObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document
public class GameState implements Serializable, Combatant {
    @Id
    String id;

    int level;

    GameField health;

    GameField attack;

    GameField defense;

    Range weaponDamage;

    int turns;

    BasicDBObject inventory;

    List<Message> messages = new ArrayList<>();

    @DBRef
    PlayerClass playerClass;

    @DBRef
    Encounter currentEncounter;

    PlayerAction currentAction;

    @Transient
    public static GameState initNewPlayer() {
        GameState newGS = new GameState();
        newGS.setLevel(1);
        newGS.setHealth(new GameField(10));
        newGS.setAttack(new GameField(10));
        newGS.setDefense(new GameField(10));
        newGS.setTurns(40);
        newGS.setWeaponDamage(new Range(1, 4));

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

    public Encounter getCurrentEncounter() {
        return currentEncounter;
    }

    public void setCurrentEncounter(Encounter currentEncounter) {
        this.currentEncounter = currentEncounter;
    }

    public PlayerAction getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(PlayerAction currentAction) {
        this.currentAction = currentAction;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void clearMessages() {
        messages.clear();
    }

    public BasicDBObject getInventory() {
        return inventory;
    }

    public void setInventory(BasicDBObject inventory) {
        this.inventory = inventory;
    }

    @Transient
    public void addMessage(Message message) {
        if (this.messages == null) {
            messages = new ArrayList<Message>();
        }

        messages.add(message);
    }
}
