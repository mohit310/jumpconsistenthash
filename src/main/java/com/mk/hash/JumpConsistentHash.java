package com.mk.hash;

public class JumpConsistentHash {

    private static final long CONSTANT = Long.parseUnsignedLong("2862933555777941757");
    private static Double JUMP = Double.sum(Integer.MAX_VALUE, 1);

    public int hash(long key, int buckets) {
        long k = key;
        long b = -1;
        long j = 0;
        while (j < buckets) {
            b = j;
            k = k * CONSTANT + 1L;
            long value = k >>> 33;
            j = (long) ((b + 1L) * (JUMP / Double.sum(value, 1.0d)));
        }
        return (int) b;
    }


    public static void main(String[] args) {
        JumpConsistentHash hash = new JumpConsistentHash();
        for (long i = 1; i <= 1000; i++) {
            System.out.println("key:" + i + " buckets:" + 10 + " hash:" + hash.hash(i, 10));
        }
    }


}
