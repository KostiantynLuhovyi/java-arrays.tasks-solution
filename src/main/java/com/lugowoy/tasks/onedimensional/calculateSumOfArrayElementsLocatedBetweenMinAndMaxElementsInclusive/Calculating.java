package com.lugowoy.tasks.onedimensional.calculateSumOfArrayElementsLocatedBetweenMinAndMaxElementsInclusive;

import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.other.ArrayChecker.checkArrayNonNull;
import static com.lugowoy.helper.other.ArrayChecker.checkLengthOfArrayIsEqualToOrGreaterThanZero;

/** Created by Konstantin Lugowoy on 27.03.2017. */

@FunctionalInterface
public interface Calculating {

    int calculate(Array<Integer> array, int indexMinElement, int indexMaxElement);

    static int calculateSumOfArrayElementsLocatedBetweenMinAndMaxElementsInclusive(Array<Integer> array, int indexMinElement,
                                                                                                         int indexMaxElement) {
        int resultSum = 0;
        try {
            if (checkArrayNonNull(array)) {
                if (checkArrayNonNull(array.getArray())
                        && checkLengthOfArrayIsEqualToOrGreaterThanZero(array.getLength())) {
                    if ((indexMinElement < indexMaxElement)) {
                        if ((indexMinElement >= 0) && (indexMaxElement > 0)) {
                            for (int i = indexMinElement; i <= indexMaxElement; i++) {
                                resultSum += array.get(i);
                            }
                        } else {
                            throw new IllegalArgumentException("The value of the index is invalid.");
                        }
                    } else {
                        throw new IllegalArgumentException("The value of the index is invalid.");
                    }
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        return resultSum;
    }

}
