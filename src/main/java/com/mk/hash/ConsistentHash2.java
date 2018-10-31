package com.mk.hash;

import java.util.Random;

public class ConsistentHash2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 1000; i++) {
            System.out.println("key:" + i + " hash:" + ch(i, 10));
        }
    }

    static int ch(long key, int num_buckets) {
        Random random = new Random();
        random.setSeed(key);
        int b = -1;//bucket number before the previous jump
        int j = 0; // bucket number before the current jump
        while (j < num_buckets) {
            b = j;
            double r = random.nextDouble();
            j = Double.valueOf(Math.floor((b + 1) / r)).intValue();
        }
        return b;
    }
}
