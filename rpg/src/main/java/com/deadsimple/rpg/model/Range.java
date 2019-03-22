package com.deadsimple.rpg.model;

import com.deadsimple.rpg.util.RandomRange;

public class Range {
    GameField minValue;

    GameField maxValue;

    public Range() {

    }

    public Range(int minValue, int maxValue) {
        this.minValue = new GameField(minValue);
        this.maxValue = new GameField(maxValue);
    }

    int generate() {
        return RandomRange.generate(minValue.getModifiedValue(), maxValue.getModifiedValue());
    }

    public GameField getMinValue() {
        return minValue;
    }

    public void setMinValue(GameField minValue) {
        this.minValue = minValue;
    }

    public GameField getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(GameField maxValue) {
        this.maxValue = maxValue;
    }

    public void setNewRange(Integer newMinValue, Integer newMaxValue) {
        this.minValue.setModifiedValue(newMinValue);
        this.maxValue.setModifiedValue(newMaxValue);
    }
}
