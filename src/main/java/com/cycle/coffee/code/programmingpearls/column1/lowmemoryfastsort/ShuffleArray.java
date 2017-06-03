package com.cycle.coffee.code.programmingpearls.column1.lowmemoryfastsort;

import java.util.*;

public class ShuffleArray {
    private static final int SHUFFLE_THRESHOLD        =    5;

    /**
     * Fastest way to get a shuffled array over a range of integers
     * @param start
     * @param end
     * @return
     */
    public static int[] getShuffledArray(int start, int end) {
        int[] arr = new int[end - start];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = start++;
        }

        Collections.shuffle(Arrays.asList(arr));
        return arr;
    }

    public static void main(String[] args) {
        getShuffledArray(10, 20);
    }

    // below implementation is from Collections class and it runs in linear time

    public static void shuffle(List<?> list, Random rnd) {
        int size = list.size();
        if (size < SHUFFLE_THRESHOLD || list instanceof RandomAccess) {
            for (int i=size; i>1; i--)
                swap(list, i-1, rnd.nextInt(i));
        } else {
            Object arr[] = list.toArray();

            // Shuffle array
            for (int i=size; i>1; i--)
                swap(arr, i-1, rnd.nextInt(i));

            // Dump array back into list
            // instead of using a raw type here, it's possible to capture
            // the wildcard but it will require a call to a supplementary
            // private method
            ListIterator it = list.listIterator();
            for (int i=0; i<arr.length; i++) {
                it.next();
                it.set(arr[i]);
            }
        }
    }

    public static void swap(List<?> list, int i, int j) {
        // instead of using a raw type here, it's possible to capture
        // the wildcard but it will require a call to a supplementary
        // private method
        final List l = list;
        l.set(i, l.set(j, l.get(i)));
    }

    private static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
