package com.codefights.arcade;

import java.util.Arrays;

/**
 * Created by zambro on 3/15/17.
 */
public class IncreasingSequenceValidator {

    public static boolean canBeMadeIncreasingSequence(int[] arr) { //{1,2,1,2}
        if(arr.length >= 3) {
            int trailingPointerShift = 0;
            int middlePointerShift = 0;
            boolean isAnomalyFound = false;

            for(int i = 1; i<arr.length - 1; i++) { //i = 1
                int trailingPointer = arr[i - 1 + trailingPointerShift]; //tp = 1 - 1 + 0 => 1
                int middlePointer = arr[i + middlePointerShift]; //mp = 1 => 2
                int forwardPointer = arr[i + 1]; // fp = 2 => 1

                if(trailingPointer == middlePointer && middlePointer == forwardPointer)
                    return false;

                if( middlePointer > forwardPointer || trailingPointer > forwardPointer || trailingPointer ==  middlePointer || middlePointer == forwardPointer) { // 3 > 2 || 1 > 2
                    if(isAnomalyFound) {    //false
                        return false;
                    } else {
                        isAnomalyFound = true; //true
                    }

                    if(trailingPointer == forwardPointer) {
                        middlePointerShift = -1;
                        trailingPointerShift = -1;
                        continue;
                    } else if( trailingPointer <= forwardPointer && middlePointer > forwardPointer) { //1<2 && 3 > 2
                        trailingPointerShift = -1; //tps = -1
                        continue;
                    } else if( trailingPointer > forwardPointer && middlePointer > forwardPointer) { // 10 > 1 && 20 > 1
                        middlePointerShift = -1;
                        trailingPointerShift = -1;
                        continue;
                    } else if( trailingPointer > middlePointer && forwardPointer > middlePointer) { // 10 > 1 && 2 > 1
                        //Flag already set
                    }
                }

                if(trailingPointerShift == -1){
                    trailingPointerShift = 0;
                }
                if(middlePointerShift == -1) {
                    trailingPointerShift = -1;
                    middlePointerShift = 0;
                }
            }
        }

        return true;
    }

    public static boolean sortArray(int[] sequence) {
        int[] arr = new int[sequence.length];
        for(int i=0; i<sequence.length;i++) {
            arr[i] = sequence[i];
        }

        Arrays.sort(sequence);
        boolean isAnomaly = false;
        for(int i=0; i<sequence.length;i++) {
            if(arr[i] != sequence[i]) {
                if(isAnomaly)
                    return false;
                else
                    isAnomaly = true;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(canBeMadeIncreasingSequence(new int[]{1, 2, 3, 5, 4, 6, 7, 8}));
    }
}
