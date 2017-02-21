package com.ctci.chapter1;

import java.util.Arrays;

/**
 * Created by zambro on 2/20/17.
 */
public class UniqueStringValidator {

    public static boolean isUniqueStringUsingCharArray(String str) {
        int[] characterBitVector = new int[257];
        for(char c: str.toCharArray()) {
            int asciiValue = (int) c;
            if(characterBitVector[asciiValue] != 0) {
                return false;
            } else {
                characterBitVector[asciiValue]++;
            }
        }

        return true;
    }

    public static boolean isUniqueString(String str) {
        char[] inputCharacters = str.toCharArray();
        Arrays.sort(inputCharacters);
        for(int i=1; i<inputCharacters.length; i++) {
            if(inputCharacters[i] == inputCharacters[i-1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isUniqueStringUsingBitVector(String str) {
        int bitVector = 0;
        for(int i=0;i<str.length();i++) {
            int bitValue = str.charAt(i) - 'a';
            if((bitVector & (1<<bitValue)) > 0) {
                return false;
            } else {
                bitVector = bitVector | (1<<bitValue);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUniqueStringUsingCharArray("hello"));
        System.out.println(isUniqueString("helo"));
        System.out.println(isUniqueStringUsingBitVector("worldw"));
    }
}
