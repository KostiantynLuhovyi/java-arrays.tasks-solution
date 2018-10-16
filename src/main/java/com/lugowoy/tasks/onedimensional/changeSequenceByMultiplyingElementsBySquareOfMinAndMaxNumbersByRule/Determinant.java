package com.lugowoy.tasks.onedimensional.changeSequenceByMultiplyingElementsBySquareOfMinAndMaxNumbersByRule;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;

/** Created by Konstantin Lugowoy on 25.03.2017. */

public interface Determinant<T> {

    T determine(Array<T> array);

    static Integer determineMinNumber(Array<Integer> array) {
        int valueForDetermineMinNumber = Integer.MAX_VALUE;
        int indexMinNumber = 0, resultFindMinNumber;
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsEqualToOrGreaterThanZero(array.getLength())) {
                for (int i = 0; i < array.getLength(); i++) {
                    if (array.get(i) <= valueForDetermineMinNumber) {
                        valueForDetermineMinNumber = array.get(i);
                        indexMinNumber = i;
                    }
                }
            }
        }
        resultFindMinNumber = array.get(indexMinNumber);
        return resultFindMinNumber;
    }

    static Integer determineMaxNumber(Array<Integer> array) {
        int valueForDetermineMaxNumber = Integer.MIN_VALUE;
        int indexMaxNumber = 0, resultFindMaxNumber;
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsEqualToOrGreaterThanZero(array.getLength())) {
                for (int i = 0; i < array.getLength(); i++) {
                    if (array.get(i) >= valueForDetermineMaxNumber) {
                        valueForDetermineMaxNumber = array.get(i);
                        indexMaxNumber = i;
                    }
                }
            }
        }
        resultFindMaxNumber = array.get(indexMaxNumber);
        return resultFindMaxNumber;
    }

}
