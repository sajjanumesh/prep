package com.pc.strings;

import java.util.*;

/**
 * Created by zambro on 4/17/17.
 *

 Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that: 1) Only one letter can be changed at a time, 2) Each intermediate word must exist in the dictionary.

 For example, given: start = "hit", end = "cog", and dict = ["hot","dot","dog","lot","log"], return:

 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]

 *
 */
public class WordLadderExtractor {

    private static class Tree{
        private String word;
        private List<String> parents;

        private Tree(String word) {
            this.word = word;
            this.parents = new ArrayList<>();
            this.parents.add(word);
        }

        private void setParents(List<String> parents) {
            this.parents = new ArrayList<>(parents);
            this.parents.add(word);
        }

    }


    public static List<List<String>> getAllShortestTransformations(String start, String end, Set<String> dict) {
        List<List<String>> list = new ArrayList<>();
        Tree node = new Tree(start);
        Queue<Tree> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            node = queue.remove();
            String word = node.word;

            if(word.equals(end)) {
                if(!list.isEmpty()){
                    if(node.parents.size()<list.get(0).size())
                        list.clear();
                    else if(node.parents.size() > list.get(0).size())
                        continue;
                }
                list.add(node.parents);
            } else {
                //Go through dict and find all chars with one char difference to the word
                dict.remove(word);
                Iterator<String> iterator = dict.iterator();
                while(iterator.hasNext()) {
                    String dictStr = iterator.next();
                    if(isDifferentByOneChar(word, dictStr)){
                        Tree tree = new Tree(dictStr);
                        tree.setParents(node.parents);
                        queue.add(tree);
                    }
                }
            }

        }
        return list;
    }


    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("hit");
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        dict.add("cog");

        System.out.println("\nAll shortest transformations: ");
        List<List<String>> lists = getAllShortestTransformations("hit", "cog", dict);
        for(List<String> list:lists)
            System.out.println(list);
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
