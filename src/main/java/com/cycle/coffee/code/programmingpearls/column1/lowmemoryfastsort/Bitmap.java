package com.cycle.coffee.code.programmingpearls.column1.lowmemoryfastsort;

/**
 * This is a memory optimized representation of integers useful for finding/removing duplicates or sorting.
 *
 * Each integer takes 32 bits. So by setting the bits at right index, we can easily represent 32 integers
 * using only enough memory required to store one integer.
 *
 */
public class Bitmap {
    private int[] arr;
    private static final int NUMBERS_TO_STORE = 10_000_000;
    private static final int RADIX = 32; // bytes per integer
    private static final int REQUIRED_SIZE = NUMBERS_TO_STORE / RADIX;

    public Bitmap() {
        this.arr = new int[REQUIRED_SIZE];
    }

    public void set(int index) {
        int bucket = index / RADIX;
        int value = arr[bucket];
        arr[bucket] = value | (1 << ((index % RADIX) - 1));
    }

    public boolean get(int index) {
        int bucket = index / RADIX;
        int value = arr[bucket];
        return (value ^ (1 << ((index % RADIX) - 1))) == 0;
    }
}
