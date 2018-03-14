package com.lugowoy.tasks.multidimensional.secondTaskForFormationOfSquareMatrixAccordingToGivenPattern;

import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.other.ArrayLength;

/** Created by Konstantin Lugowoy on 16.10.2017. */

public class Main {

    private static final int BOUND_SIZE_OF_ARRAY = 50;

    public static void main(String[] args) {

        System.out.println("Enter the length of the matrix elements : ");
        int n = ArrayLength.getLengthArray(new ReadingConsole(), BOUND_SIZE_OF_ARRAY);

        int [][] array = new int[n][n];

        int indexNum = array.length - 1, num = 1;
        for (int i = 0; i < array.length; i++) {
            array[i][indexNum] = num;
            num++;
            indexNum--;
        }

        System.out.println("Result matrix  : ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }


}
