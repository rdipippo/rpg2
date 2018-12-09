package com.deadsimple.rpg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Item {
    @Id
    String id;

    String name;

    String gameName;

    public Item() {
    }

    public GameState onEquip(GameState gs) {
        return gs;
    }

    public GameState onUnequip(GameState gs) {
        return gs;
    }

    public GameState onReceive(GameState gs) {
        return gs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
}
