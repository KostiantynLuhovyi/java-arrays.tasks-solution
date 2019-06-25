package com.lugowoy.tasks.multidimensional.constructPascalTriangle;

/**
 * Write a program that builds a Pascal triangle to a depth of 12.
 * Each number of a triangle is stored in an array of the appropriate length, and the array of rows is stored in an array,
 * the elements of which are 12 arrays of type int.
 * <p>
 * Created by Konstantin Lugowoy on 28.06.2017.
 */

public class Main {

    private static final int LENGTH_PASCAL_TRIANGLE = 12;

    public static void main(String[] args) {

        int[][] pascalTriangle = new int[LENGTH_PASCAL_TRIANGLE][];

        showPascalTriangle(pascalTriangle);

    }

    private static void showPascalTriangle(int[][] emptyTriangleArray) {
        emptyTriangleArray[0] = new int[1];
        emptyTriangleArray[1] = new int[2];
        emptyTriangleArray[1][0] = emptyTriangleArray[1][1] = 1;

        System.out.println(emptyTriangleArray[0][0] = 1);
        System.out.println(emptyTriangleArray[1][0] + " " + emptyTriangleArray[1][1]);

        for (int i = 2; i < emptyTriangleArray.length; i++) {

            emptyTriangleArray[i] = new int[i + 1];
            System.out.print((emptyTriangleArray[i][0] = 1) + " ");

            for (int j = 1; j < i; j++) {
                System.out.print((emptyTriangleArray[i][j] = emptyTriangleArray[i - 1][j - 1] + emptyTriangleArray[i - 1][j]) + " ");
            }
            System.out.println(emptyTriangleArray[i][i] = 1);
        }

    }

}
