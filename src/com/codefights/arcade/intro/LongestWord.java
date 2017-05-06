package com.codefights.arcade.intro;

/**
 * Created by zambro on 4/19/17.
 */
public class LongestWord {

    public static String longestWord(String text) {
        String max = "";
        int start = -1;
        char[] c = text.toCharArray();
        boolean isFirstCharacterFound = false;
        int i=0;
        for(;i<c.length;i++) {
            if(!Character.isLetter(c[i])) {
                if (isFirstCharacterFound && max.length() < text.substring(start, i).length())
                    max = text.substring(start, i);
                isFirstCharacterFound = false;
            } else {
                if(!isFirstCharacterFound){
                    start = i;
                    isFirstCharacterFound = true;
                }
            }
        }

        if(start == 0 && i == c.length)
            return text;

        return max;

    }

    public static void main(String[] args) {
        System.out.println(longestWord("Ready, steady, go!"));
        System.out.println(longestWord("Ready[[[, steady, go!"));
        System.out.println(longestWord("ABCd"));
        System.out.println(longestWord("To be or not to be"));
        System.out.println(longestWord("You are the best!!!!!!!!!!!! CodeFighter ever!"));
        System.out.println(longestWord("!! AA[]z"));

    }
}
