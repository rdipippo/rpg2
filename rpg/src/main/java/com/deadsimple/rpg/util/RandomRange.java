package com.deadsimple.rpg.util;

import java.util.Random;

public class RandomRange {
    public static int generate(int lowBound, int highBound) {
        Random rnd = new Random();
        return rnd.nextInt(lowBound + 1) + highBound;
    }
}
