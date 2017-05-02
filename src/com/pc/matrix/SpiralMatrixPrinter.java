package com.pc.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zambro on 5/2/17.
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * For example, given the following matrix:
 * <p>
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrixPrinter {

    public static List<Integer> returnSpiral(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return list;

        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++)
                list.add(matrix[top][i]);
            top++;

            for (int i = top; i <= bottom; i++)
                list.add(matrix[i][right]);
            right--;

            if(top <= bottom)
            for (int i = right; i >= left; i--)
                list.add(matrix[bottom][i]);
            bottom--;

            if(left <= right)
            for (int i = bottom; i >= top; i--)
                list.add(matrix[i][left]);
            left++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] m = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(returnSpiral(m));

        int[][] m1 = {{1,2,3}};
        System.out.println(returnSpiral(m1));

        int[][] m2 = {{1},
                      {2},
                      {3}};
        System.out.println(returnSpiral(m2));

        int[][] m3 = {{1,2},{3,4}};
        System.out.println(returnSpiral(m3));

    }
}
