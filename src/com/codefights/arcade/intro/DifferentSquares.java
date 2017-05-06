package com.codefights.arcade.intro;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zambro on 4/26/17.
 * Given a rectangular matrix containing only digits, calculate the number of different 2 × 2 squares in it.

 Example

 For

 matrix = [[1, 2, 1],
 [2, 2, 2],
 [2, 2, 2],
 [1, 2, 3],
 [2, 2, 1]]
 the output should be
 differentSquares(matrix) = 6.

 Here are all 6 different 2 × 2 squares:

 1 2
 2 2
 2 1
 2 2
 2 2
 2 2
 2 2
 1 2
 2 2
 2 3
 2 3
 2 1
 */
public class DifferentSquares {

   public static int differentSquares(int[][] matrix) {
        if(matrix.length < 2 || matrix[0].length < 2)
            return 0;

        Set<String> set = new HashSet<>();
        for(int i=0;i<matrix.length-1;i++) {
            for(int j=0;j<matrix[i].length-1;j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(matrix[i][j]);
                sb.append(matrix[i][j+1]);
                sb.append(matrix[i+1][j]);
                sb.append(matrix[i+1][j+1]);
                set.add(sb.toString());
            }
        }

        return set.size();
    }


    public static void main(String[] args) {
       int[][] matrix = {{1,2,1},
               {2,2,2},
               {2,2,2},
               {1,2,3},
               {2,2,1}};
       System.out.println(differentSquares(matrix));
    }
}
