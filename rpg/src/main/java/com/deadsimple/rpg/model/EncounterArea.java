package com.deadsimple.rpg.model;

import com.deadsimple.rpg.util.RandomRange;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class EncounterArea {
    @Id
    String id;

    int turnCost;

    String name;

    String gameName;

    List<Encounter> encounters;

    public EncounterArea() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTurnCost() {
        return turnCost;
    }

    public void setTurnCost(int turnCost) {
        this.turnCost = turnCost;
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

    public List<Encounter> getEncounters() {
        return encounters;
    }

    public void setEncounters(List<Encounter> encounters) {
        this.encounters = encounters;
    }

    public Encounter selectEncounter() {
        int encounterIndex = RandomRange.generate(0, encounters.size() - 1);
        return encounters.get(encounterIndex);
    }
}
