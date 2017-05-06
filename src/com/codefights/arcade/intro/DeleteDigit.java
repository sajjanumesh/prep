package com.codefights.arcade.intro;

/**
 * Created by zambro on 4/17/17.
 * Given some integer, find the maximal number you can obtain by deleting exactly one digit of the given number.

 Example

 For n = 152, the output should be
 deleteDigit(n) = 52;
 For n = 1001, the output should be
 deleteDigit(n) = 101.
 */
public class DeleteDigit {

    public static int deleteDigit(int n) {
        int max = 0;
        String s = n+"";
        for(int i=0;i<s.length();i++) {
            String sub = s.substring(0,i) + s.substring(i+1);
            int number = Integer.parseInt(sub);
            if(number > max) {
                max = number;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(deleteDigit(222219));
    }

}
