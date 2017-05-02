package com.pc.matrix;

import java.util.Arrays;

/**
 * Created by zambro on 5/1/17.
 * Given a m * n matrix, if an element is 0, set its entire row and column to 0.
 Do it in place
 Ex:

 1 3 4 5
 5 0 7 3
 6 3 2 2

 becomes

 1 0 4 5
 0 0 0 0
 6 0 2 2
 */
public class MatrixZeroes {

    public static void setZeroes(int[][] matrix){
        boolean isFirstRowZero = false, isFirstColZero = false;

        for(int col=0;col<matrix[0].length;col++){
            if(matrix[0][col] == 0) {
                isFirstRowZero = true;
                break;
            }
        }

        for(int row=0;row<matrix.length;row++){
            if(matrix[row][0] == 0) {
                isFirstColZero = true;
                break;
            }
        }

        for(int row = 1;row<matrix.length;row++) {
            for(int col=1;col<matrix[row].length;col++) {
                if(matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for(int row=1;row<matrix.length;row++) {
            if(matrix[row][0] == 0) {
                //Found a cell in first column as zero, so lets zero the entire row
                for(int col=1;col<matrix[row].length;col++)
                    matrix[row][col] = 0;
            }
        }

        for(int col=1;col<matrix[0].length;col++) {
            if(matrix[0][col] == 0) {
                //Found a cell in the first column as zero, so lets zero the entire column
                for(int row=1;row<matrix.length;row++) {
                    matrix[row][col] = 0;
                }
            }
        }

        if(isFirstColZero) {
            for(int row=0;row<matrix.length;row++)
                matrix[row][0] = 0;
        }

        if(isFirstRowZero) {
            for(int col=0;col<matrix[0].length;col++)
                matrix[0][col] = 0;
        }

    }

    public static void main(String[] args) {
        int[][] m1 = {  {1,3,4,5},
                        {5,0,7,3},
                        {6,3,2,2}};
        setZeroes(m1);
        System.out.println(Arrays.deepToString(m1));

        int[][] m2 = {  {1,3,4,5},
                        {5,0,0,3},
                        {6,3,2,2}};
        setZeroes(m2);
        System.out.println(Arrays.deepToString(m2));

        int[][] m3 = {  {1,3,0,5},
                        {5,1,7,3},
                        {6,3,2,2}};
        setZeroes(m3);
        System.out.println(Arrays.deepToString(m3));

        int[][] matrix = {
                {1,1,2,1,1},
                {0,2,3,1,1},
                {1,1,1,0,1},
                {1,1,0,1,1}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
