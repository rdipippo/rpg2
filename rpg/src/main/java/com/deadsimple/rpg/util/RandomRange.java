package com.deadsimple.rpg.util;

import java.util.Random;

public class RandomRange {
    static Random rnd = new Random();

    public static int generate(int lowBound, int highBound) {
        return rnd.nextInt(lowBound + 1) + highBound;
    }

    public static boolean trueOrFalse() {
        return rnd.nextBoolean();
    }
}
