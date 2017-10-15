package com.lugowoy.tasks.multidimensional.firstTaskForFormationOfSquareMatrixAccordingToGivenPattern;

import com.lugowoy.helper.other.DeterminatorSizeOfArray;

import java.util.Objects;

/** Created by Konstantin Lugowoy on 15.10.2017. */

public class Main {

    private static final int BOUND_SIZE_OF_ARRAY = 50;

    public static void main(String[] args) {

        int [][] array = null;

        int n = DeterminatorSizeOfArray.determineSizeOfArray(BOUND_SIZE_OF_ARRAY);

        if (n % 2 == 0) {
            array = new int[n][n];
            int k = 1, num = n;

            for (int i = 0; i < array.length; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < array.length; j++) {
                        array[i][j] = k;
                        k++;
                    }
                    k = 1;
                } else {
                    for (int j = 0; j < array.length; j++) {
                        array[i][j] = num;
                        num--;
                    }
                    num = n;
                }
            }
        }

        System.out.println("Result array : ");
        if (Objects.nonNull(array)) {
            for(int i = 0; i < array.length; i++) {
                for(int  j = 0; j < array.length; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
        }


    }


}
