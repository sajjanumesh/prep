package com.codefights.arcade.intro;

/**
 * Created by zambro on 4/26/17.
 * Given an integer product, find the smallest positive integer the product of whose digits is equal to product. If there is no such integer, return -1 instead.

 Example

 For product = 12, the output should be
 digitsProduct(product) = 26;
 For product = 19, the output should be
 digitsProduct(product) = -1.

 */
public class DigitsProduct {

    public static int digitsProduct(int product) {
        //Special case
        if(product == 0)
            return 10;

        if(product < 10)
            return product;

        int start = 2;
        int min = Integer.MAX_VALUE;

        while(start < 10 && start <= product) {
            int p = product;

            if(p % start == 0) {
                //Found a number that divides the product
                p = p / start;
                int nextDividers = digitsProduct(p);
                if(nextDividers != -1) {
                    int number;
                    if(nextDividers == 1) {
                        number = start;
                    } else {
                        int length = (int)(Math.log10(nextDividers)+1);
                        number = start * (int) Math.pow(10,length) + nextDividers;
                    }

                    if(number < min)
                        min = number;
                }
            }
            start++;
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }


    public static void main(String[] args) {
        System.out.println(digitsProduct(12));
        System.out.println(digitsProduct(19));
        System.out.println(digitsProduct(450));
        System.out.println(digitsProduct(0));
    }


}
