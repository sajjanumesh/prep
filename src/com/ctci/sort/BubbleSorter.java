package com.ctci.sort;

import java.util.Arrays;

/**
 * Created by zambro on 3/31/17.
 */
public class BubbleSorter {

    public static void sort(int[] arr) {
        int length = arr.length;
        for(int i=0;i<length;length--){
            for(int j=i+1;j<length;j++) {
                if(arr[j-1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,4534,232,434,22};
        sort(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{2,2,2,0};
        sort(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{-234,-234,23,42,0,4234,-24234,0,-2342,234,0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
