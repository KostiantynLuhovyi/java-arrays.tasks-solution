package com.lugowoy.tasks.onedimensional.calculateSumOfArrayElementsLocatedBetweenMinAndMaxElementsInclusive;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;

/** Created by Konstantin Lugowoy on 27.03.2017. */

@FunctionalInterface
public interface Determinant {

    int determine(Array<Integer> array);

    static int determineMinElementIndex(Array<Integer> array) {
        int indexMinElement = 0, valueForDetermineMinElementIndex = Integer.MAX_VALUE;
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsEqualToOrGreaterThanZero(array.getLength())) {
                for (int i = 0; i < array.getLength(); i++) {
                    if (array.get(i) < valueForDetermineMinElementIndex) {
                        valueForDetermineMinElementIndex = array.get(i);
                        indexMinElement = i;
                    }
                }
            }
        }
        return indexMinElement;
    }

    static int determineMaxElementIndex(Array<Integer> array) {
        int indexMaxElement = 0, valueForDetermineMaxElementIndex = Integer.MIN_VALUE;
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsEqualToOrGreaterThanZero(array.getLength())) {
                for (int i = 0; i < array.getLength(); i++) {
                    if (array.get(i) > valueForDetermineMaxElementIndex) {
                        valueForDetermineMaxElementIndex = array.get(i);
                        indexMaxElement = i;
                    }
                }
            }
        }
        return indexMaxElement;
    }

}
