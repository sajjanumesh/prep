package com.pc.strings;

/**
 * Created by zambro on 3/6/17.
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

 The input string does not contain leading or trailing spaces and the words are always separated by a single space.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".


 */
public class WordRotator {

    public static String reverseWorsInString(String str) {
        char[] arr = str.toCharArray();

        //Reverse the string
        reverseArray(arr, 0, arr.length - 1);

        //Reverse the substrings within space
        int start = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == ' ') {
                //Found a space, lets reverse this substring
                reverseArray(arr, start, i-1);
                start = i+1;
            }
        }

        //Reverse the last substring
        reverseArray(arr, start, arr.length-1);

        return new String(arr);
    }

    public static void reverseArray(char[] arr, int start, int end) {
        if(arr == null || arr.length <= 1) {
            return;
        }

        while(start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String str = "hello world ; this is a test input ";
        System.out.println(reverseWorsInString(str));
    }
}
