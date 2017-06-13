package com.coffee.code.repeat.programmingpearls.column2.missingnumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Given a sequential file that contains at most four billion 32-bit integers in random order,
 * find a 32-bit integer that isn’t in the file (and there must be at least one missing — why?).
 * - there are 2^32 = 4,294,967,296 32 bit numbers. So there must be at least 294,967,296 missing numbers.
 * How would you solve this problem with ample quantities of main memory?
 * How would you solve it if you could use several external “scratch” files but only a few hundred bytes of main memory?
 */
public class MissingNumber {
    private static final int MAX_32BIT_NUMS = 2 ^ 32;
    public static void main(String[] args) {

    }

    /**
     * While this is not a memory intensive implementation, it still requires a constant memory
     * @param nums
     * @return
     * @throws Exception
     */
    private static int findFirstMissingWithAmpleMemory(int[] nums) throws Exception{
        boolean[] buffer = new boolean[MAX_32BIT_NUMS];
        for(int i: nums) {
            buffer[i] = true;
        }

        for(int i = 0; i < MAX_32BIT_NUMS; i++) {
            if(buffer[i] != true) {
                return i;
            }
        }
        throw new Exception("No missing number found");
    }

    private static class RandomNumbers {

        int[] getRandomNumbers(int count) {
            List<Integer> nums = new ArrayList<>(MAX_32BIT_NUMS);
            for(int i = 0; i< MAX_32BIT_NUMS; i++) {
                nums.add(i);
            }
            Random random = new Random();
            for(int i = count; i < MAX_32BIT_NUMS; i++) {
                nums.remove(random.nextInt(MAX_32BIT_NUMS));
            }

            Collections.shuffle(nums);

            int[] res = new int[nums.size()];
            int index = 0;
            for(int i : nums) {
                res[index++] = i;
            }
            return res;
        }
    }
}


