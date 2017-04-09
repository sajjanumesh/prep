package com.pc.strings;

import java.util.Arrays;

/**
 * Created by zambro on 3/6/17.
 * Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */
public class StringRotator {

    public static void rotateArray(int[] arr, int k) {
        if(arr == null || arr.length <= 1) {
            return;
        }

        //Bring k within length
        k = k % arr.length;

        //Reverse from 0 to n-1-k
        reverseArray(arr, 0, arr.length-1-k);
        reverseArray(arr, arr.length-k, arr.length-1);
        reverseArray(arr, 0, arr.length-1);
    }

    public static void reverseArray(int[] arr, int start, int end) {
        if(arr == null || arr.length == 1) {
            return;
        }

        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1,2,3,4,5,6,7};
        rotateArray(arr, 10);
        System.out.println(Arrays.toString(arr));
    }
}
