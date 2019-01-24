package com.deadsimple.rpg.model;

public class PlayerAction {
    String name;

    Cost cost;

    public PlayerAction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }
}
