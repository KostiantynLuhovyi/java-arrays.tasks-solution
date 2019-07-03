package com.lugowoy.tasks.multidimensional.thirdTaskForFormationOfSquareMatrixAccordingToGivenPattern;

import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.other.LengthReader;

/**
 * Form a square matrix of order n according to a given pattern:
 * n	0	0	…	0	0	0
 * 0	n-1	0	…	0	0	0
 * 0	0	n-2	…	0	0	0
 * …	…	…	…	…	…	…
 * 0	0	0	…	0	2	0
 * 0	0	0	…	0	0	1
 * <p>
 * Created by Konstantin Lugowoy on 16.10.2017.
 */

public class Main {

    private static final int UPPER_BOUND = 50;

    public static void main(String[] args) {

        System.out.println("Enter the length of the matrix elements : ");
        int n = LengthReader.readLength(new ReadingConsole(), UPPER_BOUND);

        int[][] array = new int[n][n];

        int numIndex = 0, num = n;
        for (int i = 0; i < array.length; i++) {
            array[i][numIndex] = num;
            numIndex++;
            num--;
        }

        System.out.println("Result matrix : ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }

}
