package com.deadsimple.rpg.model;

import org.apache.commons.lang.reflect.FieldUtils;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.reflect.Field;

@Document(collection = "effect")
/** TODO THis is an absolute effect instead of a relative effect.
 *  In other words the old value is erased when the new value is set.
 *  I.E your hands do 1-4 dmg; you equip a weapon that does 10-20.
 *  Your new range is just 10-20.
 *  So somehow you have to remember that the original range was 1-4.
 *  You have to do it over multiple equips in case the user goes through
 *  10 different weapons and then unequips the 10th, going back to the 1-4 range for hands.
 *  We can store the weapons range in the modifiedValue on the GameFields, but how do we
 *  know to go back to the base range?
 *
 *  TODO ALSO you have to recalculate any modifiers to the range once this effect takes place.
 *  Continuing above example: You have no weapon (1-4 dmg) but equip another item that gives +2 damage,
 *  making the range 3-6. You equip a weapon that does 10-20, now your range has to be 12-22.
 *  So really, it's like the range itself has to maintain a list of its own modifiers.
 *
 *  Yeesh.
 */
public class RangeEffect implements Effect {
    int minValue;

    int maxValue;

    String gameStateField;

    public RangeEffect() {

    }

    public RangeEffect(String field, int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.gameStateField = field;
    }

    @Override
    public GameState apply(GameState gs) {
        try {
            Field declaredField = FieldUtils.getDeclaredField(GameState.class, gameStateField, true);
            Range range = (Range)declaredField.get(gs);
            range.setNewRange(minValue, maxValue);
        } catch (IllegalAccessException e) {

        }

        return gs;
    }

    @Override
    public GameState unapply(GameState gs) {
        try {
            Field declaredField = FieldUtils.getDeclaredField(GameState.class, gameStateField, true);
            Range range = (Range)declaredField.get(gs);

        } catch (IllegalAccessException e) {

        }
    }

    public Range getNewRange() {
        return newRange;
    }

    public void setNewRange(Range newRange) {
        this.newRange.setNewRange(newRange.getMinValue(), newRange.getMaxValue());
    }

    public String getGameStateField() {
        return gameStateField;
    }

    public void setGameStateField(String gameStateField) {
        this.gameStateField = gameStateField;
    }
}
