package com.deadsimple.rpg.model;

public class Cost {
    String gameStateField;

    int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public GameState apply(GameState gs) {
        try {
            GameField field = (GameField) GameState.class.getField(gameStateField).get(gs);
            field.setModifiedValue(field.getModifiedValue() - amount);

            return gs;
        } catch (IllegalAccessException|NoSuchFieldException e) {
            e.printStackTrace();
            return gs;
        }
    }
}
