package com.pc.strings;

import java.util.*;

/**
 * Created by zambro on 4/17/17.
 *

 Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that only one letter can be changed at a time and each intermediate word must exist in the dictionary. For example, given:

 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", the program should return its length 5.


 *
 */
public class WordLadderValidator {

    private static class Tree{
        private String word;
        private int level;

        private Tree(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    public static int getTransformationCount(String start, String end, Set<String> dict) {
        Tree node = new Tree(start, 1);
        Queue<Tree> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            node = queue.remove();
            String word = node.word;
            int level = node.level;

            if(word.equals(end))
                return level;

            //Go through dict and find all chars with one char difference to the word
            Iterator<String> iterator = dict.iterator();
            while(iterator.hasNext()) {
                String dictStr = iterator.next();
                if(isDifferentByOneChar(word, dictStr)){
                    queue.add(new Tree(dictStr, level+1));
                    iterator.remove();
                }
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("hut");
        dict.add("hat");
        dict.add("hot");
        dict.add("dot");
        dict.add("him");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        dict.add("cog");

        System.out.println(getTransformationCount("hit", "cog", dict));
    }

    /**
     * Find if both strings of equal length are different by exactly one character
     */
    public static boolean isDifferentByOneChar(String str1, String str2) {
        if(str1.length() != str2.length())
            return false;

        boolean isDifferenceFound=false;
        for(int i=0;i<str1.length();i++) {
            if(str1.charAt(i) != str2.charAt(i))
                if(isDifferenceFound)
                    return false;
                else
                    isDifferenceFound = true;
        }

        //We want to make sure there is exactly one difference
        return isDifferenceFound;
    }
}
