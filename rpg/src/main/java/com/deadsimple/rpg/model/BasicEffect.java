package com.deadsimple.rpg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.beans.Transient;
import java.lang.reflect.Field;

@Document(collection = "effect")
public class BasicEffect implements Effect {
    @Id
    String id;

    String gameStateField;

    int modifier;

    enum BasicEffectType {
        LINEAR,
        PERCENT
    };

    BasicEffectType type;

    public String getGameStateField() {
        return gameStateField;
    }

    public void setGameStateField(String gameStateField) {
        this.gameStateField = gameStateField;
    }

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    public BasicEffectType getType() {
        return type;
    }

    public void setType(BasicEffectType type) {
        this.type = type;
    }

    @Transient
    private GameState applyOrUnapply(GameState gs, int modifier) {
        Integer newValue = 0;

        try {
            Field f = GameState.class.getDeclaredField(gameStateField);
            f.setAccessible(true);
            GameField field = (GameField)f.get(gs);

            if (type.equals(BasicEffectType.LINEAR)) {
                newValue = field.getModifiedValue() + modifier;
            } else if (type.equals(BasicEffectType.PERCENT)) {
                Float valueToAdd = field.getBaseValue() * (Float.valueOf(modifier) / 100);
                newValue = (int)(field.getModifiedValue() + valueToAdd);
            }

            field.setModifiedValue(newValue);
            f.set(gs, field);
            return gs;
        } catch (IllegalAccessException|NoSuchFieldException e) {
            e.printStackTrace();
            return gs;
        }
    }

    @Override
    @Transient
    public GameState apply(GameState gs) {
        return applyOrUnapply(gs, modifier);
    }

    @Override
    @Transient
    public GameState unapply(GameState gs) {
        return applyOrUnapply(gs, modifier * -1);
    }
}
