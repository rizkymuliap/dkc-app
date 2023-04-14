package com.dkc.models.repos;

import java.util.Random;

public class Uniqid {
    private static final Random RANDOM = new Random();

    public static String generate() {
        long timestamp = System.currentTimeMillis();
        int random = RANDOM.nextInt(9999);
        return String.format("%d%d", timestamp, random);
    }
}
