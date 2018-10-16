package com.lugowoy.tasks.onedimensional.determineWhetherElementsOfSecondSequenceInFirstSequence;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;

/** Created by Konstantin Lugowoy on 12.04.2017. */

@FunctionalInterface
public interface Determinant<T> {

    boolean determine(T tFirst, T tSecond);

    static boolean determineWhetherTheElementsOfTheSecondSequenceInTheFirstSequence(Array<Integer> firstArray,
                                                                                    Array<Integer> secondArray) {
        boolean result = true;
        if (CheckerArray.checkArrayNonNull(firstArray) && CheckerArray.checkArrayNonNull(secondArray)) {
            if (CheckerArray.checkLengthOfArrayIsGreaterZero(firstArray.getLength())
                    && CheckerArray.checkLengthOfArrayIsGreaterZero(secondArray.getLength())) {
                label:
                for (int i = 0; i < firstArray.getLength(); i++) {
                    for (int j = 0; j < secondArray.getLength(); j++) {
                        if (i == j) continue label;
                        result = false;
                    }
                }
            }
        }
        return result;
    }

}
