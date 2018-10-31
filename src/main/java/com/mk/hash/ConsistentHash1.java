package com.mk.hash;

import java.util.Random;

public class ConsistentHash1 {

    public static void main(String[] args) {
        for (int i = 1; i <= 1000; i++) {
            System.out.println("key:" + i + " hash:" + ch(i, 10));
        }
    }

    static int ch(long key, int num_buckets) {
        Random random = new Random();
        random.setSeed(key);
        int b = 0; // This will track ch(key, j+1).
        for (int j = 1; j < num_buckets; j++) {
            double div = 1.0 / (j + 1);
            double randomNo = random.nextDouble();
            if (randomNo < div) b = j;
        }
        return b;
    }
}
