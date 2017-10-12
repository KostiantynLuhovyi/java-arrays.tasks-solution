package com.lugowoy.tasks.onedimensional.calculateTheSumOfArrayElementsLocatedBetweenTheMinAndMaxElementsInclusive;

import com.lugowoy.helper.models.arrays.Array;

/** Created by Konstantin Lugowoy on 27.03.2017. */

@FunctionalInterface
public interface Calculable {

    int calculate(Array<Integer> array, int indexMinElement, int indexMaxElement);

    static int calculateTheSumOfArrayElementsLocatedBetweenTheMinAndMaxElementsInclusive(Array<Integer> array, int indexMinElement, int indexMaxElement) {
        int resultSum = 0;
        if (array != null) {
            if ((array.getArray() != null) && (array.getArray().length > 0)) {
                if ((indexMinElement < indexMaxElement)) {
                    if ((indexMinElement >= 0) && (indexMaxElement > 0)) {
                        for (int i = indexMinElement; i <= indexMaxElement; i++) {
                            resultSum += array.getArray()[i];
                        }
                    } else {
                        System.out.println("The value of the index is invalid.");
                    }
                } else {
                    System.out.println("The value of the index is invalid.");
                }
            } else {
                System.out.println("The array is not valid for any operations or calculations.");
            }
        } else {
            System.out.println("The array is not valid for any operations or calculations.");
        }
        return resultSum;
    }

}
