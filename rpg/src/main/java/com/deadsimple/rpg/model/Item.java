package com.deadsimple.rpg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Item {
    @Id
    String id;

    String name;

    String gameName;

    List<Effect> equipEffects;

    public Item() {
    }

    /**
     * TODO How do we handle slots?
     * In other words if you equip a weapon, it unequips your existing weapon automatically,
     * but if you equip a regular item, it just equips - unless there is something already in that slot.x
     * @param gs
     * @return
     */
    public GameState onEquip(GameState gs) {
        for (Effect effect : equipEffects) {
            effect.apply(gs);
        }

        return gs;
    }

    public GameState onUnequip(GameState gs) {
        for (Effect effect : equipEffects) {
            effect.unapply(gs);
        }

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

    public List<Effect> getEquipEffects() {
        return equipEffects;
    }

    public void setEquipEffects(List<Effect> equipEffects) {
        this.equipEffects = equipEffects;
    }
}
