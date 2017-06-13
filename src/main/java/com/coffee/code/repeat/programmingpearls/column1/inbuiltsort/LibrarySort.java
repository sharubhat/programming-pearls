package com.coffee.code.repeat.programmingpearls.column1.inbuiltsort;

import com.coffee.code.repeat.programmingpearls.column1.lowmemoryfastsort.FastSystemSort;
import com.coffee.code.repeat.programmingpearls.column1.lowmemoryfastsort.ShuffleArray;

public class LibrarySort {
    private static final int MAX_INT = 10_000_000;
    private static final int MIN_INT = 0;

    public static void main(String[] args) {
        int[] arr = ShuffleArray.getShuffledArray(MIN_INT, MAX_INT);
        FastSystemSort fs = new FastSystemSort();
        long startTime = System.currentTimeMillis();
        fs.sort(arr);
        System.out.println("Library sort time: " + (System.currentTimeMillis() - startTime));
    }
}
