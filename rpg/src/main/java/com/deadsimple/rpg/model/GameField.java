package com.deadsimple.rpg.model;

public class GameField {
    int baseValue;

    int modifiedValue;

    public GameField(int baseValue) {
        this.baseValue = baseValue;
        this.modifiedValue = baseValue;
    }

    public int getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(int baseValue) {
        this.baseValue = baseValue;
    }

    public int getModifiedValue() {
        return modifiedValue;
    }

    public void setModifiedValue(int modifiedValue) {
        this.modifiedValue = modifiedValue;
    }

    public void subtract(int valueToSubtract) {
        this.modifiedValue -= valueToSubtract;
        if (modifiedValue < 0) {
            modifiedValue = 0;
        }
    }
}
