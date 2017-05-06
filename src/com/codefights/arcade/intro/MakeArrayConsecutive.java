package com.codefights.arcade.intro;

import java.util.Arrays;

/**
 * Created by zambro on 3/9/17.
 */
public class MakeArrayConsecutive {
    /**
     * https://codefights.com/arcade/intro/level-2/bq2XnSr5kbHqpHGJC/description
     * Ratiorg got statues of different sizes as a present from CodeMaster for his birthday, each statue having an non-negative integer size. Since he likes to make things perfect, he wants to arrange them from smallest to largest so that each statue will be bigger than the previous one exactly by 1. He may need some additional statues to be able to accomplish that. Help him figure out the minimum number of additional statues needed.

     Example

     For statues = [6, 2, 3, 8], the output should be
     makeArrayConsecutive2(statues) = 3.

     Ratiorg needs statues of sizes 4, 5 and 7.

     */

    /**
     * Find the min, max
     * min = 2, max = 8
     *
     * diff = max - min + 1 = 7 => So we need a total of 7 chars in the array
     * but we have only arr.length
     *
     * so the difference should yield the total missing elements
     *
     */
    public static int makeArrayConsecutive(int[] statues) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i : statues) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        return max - min + 1 - statues.length;
    }

    public static int makeArrayConsecutive2(int[] statues) {
        Arrays.sort(statues);
        int missingNumbers = 0;
        for(int i=1;i<statues.length;i++){
            if(statues[i] - statues[i-1] > 1) {
                missingNumbers += statues[i] - statues[i-1] - 1;
            }
        }

        return missingNumbers;
    }

    public static void main(String[] args) {
        System.out.println(makeArrayConsecutive(new int[]{6,2,3,8}));
        System.out.println(makeArrayConsecutive2(new int[]{6,2,3,8}));
        System.out.println(makeArrayConsecutive(new int[]{6,2,3,8,13,12}));
        System.out.println(makeArrayConsecutive2(new int[]{6,2,3,8,13,12}));
        System.out.println(makeArrayConsecutive(new int[]{22,6,2,3,8,13,12}));
        System.out.println(makeArrayConsecutive2(new int[]{22,6,2,3,8,13,12}));
        System.out.println(makeArrayConsecutive(new int[]{6,2,3,100,8,13,12}));
        System.out.println(makeArrayConsecutive2(new int[]{6,2,3,8,100,13,12}));
    }
}
