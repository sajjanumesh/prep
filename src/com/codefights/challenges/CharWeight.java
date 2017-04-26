package com.codefights.challenges;

import java.util.*;

/**
 * Created by zambro on 4/23/17.
 * Given a string s, your task is to calculate the weight of each character in it, where weight is the number of times a character appears in the string (case insensitive).

 The answer should be returned as a string in the format char1{weight1}char2{weight2}..., with the characters sorted as follows:

 The characters with larger weights should come first;
 In the case of a tie, the characters should be sorted by their char code values in ascending order.
 Example

 For s = "codefights", the output should be
 charWeight = "c{1}d{1}e{1}f{1}g{1}h{1}i{1}o{1}s{1}t{1}"

 Each character appears in s exactly once, so the characters are sorted by their char codes.

 For s = "Google", the output should be
 charWeight = "g{2}o{2}e{1}l{1}"

 The letters 'g' and 'o' both appear twice, so they come first, followed by the other letters.


 */
public class CharWeight {

    public static String getCharWeight(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            char c = Character.toLowerCase(s.charAt(i));
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            } else {
                map.put(c,1);
            }
        }

        List<Map.Entry<Character, Integer>> list =
                new LinkedList<Map.Entry<Character, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            sb.append(entry.getKey());
            sb.append("{");
            sb.append(entry.getValue());
            sb.append("}");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getCharWeight("Google"));
        System.out.println(getCharWeight("codefights"));
    }
}
