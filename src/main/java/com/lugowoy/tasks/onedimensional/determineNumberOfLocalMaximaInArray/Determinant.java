package com.lugowoy.tasks.onedimensional.determineNumberOfLocalMaximaInArray;

import com.lugowoy.helper.models.Array;

/** Created by Konstantin Lugowoy on 07.05.2018. */

@FunctionalInterface
public interface Determinant {

    void determine(Array<Integer> array);

    static void determineNumbersOfLocalMaximum(Array<Integer> array) {
        int counterOfLocalMaximum = 0;
        for (int i = 1; i < array.getLength() - 1; i++) {
            if ((array.get(i - 1) > array.get(i)) && (array.get(i + 1) > array.get(i))) {
                print(array.get(i), i);
                counterOfLocalMaximum++;
            }
        }
        if (counterOfLocalMaximum == 0) {
            System.out.println("The array did not determine numbers that would be considered local maximum.");
        }
    }

    private static void print(int number, int indexOfNumber) {
        System.out.printf("The number %d under the index %d is the local maximum.\n", number, indexOfNumber);
    }

}
