package com.deadsimple.rpg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public abstract class Encounter {
    @Id
    String id;

    String name;

    String openingText;

    List<PlayerAction> actions;

    public Encounter() {
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

    public String getOpeningText() {
        return openingText;
    }

    public void setOpeningText(String openingText) {
        this.openingText = openingText;
    }

    public List<PlayerAction> getActions() {
        return actions;
    }

    public void setActions(List<PlayerAction> actions) {
        this.actions = actions;
    }

    public abstract GameState run(GameState gs);

    public abstract GameState nextStage(GameState gs);

    public abstract GameState processPlayerAction(GameState gs);

    public abstract GameState complete(GameState gs);

    public abstract boolean isComplete(GameState gs);
}
