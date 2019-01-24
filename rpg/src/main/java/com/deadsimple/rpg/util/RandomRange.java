package com.deadsimple.rpg.util;

import java.util.Random;

public class RandomRange {
    static Random rnd = new Random();

    public static int generate(int lowBound, int highBound) {
        if (lowBound == highBound) {
            return lowBound;
        }
        return rnd.nextInt(highBound - lowBound) + lowBound;
    }

    public static boolean trueOrFalse() {
        return rnd.nextBoolean();
    }
}
