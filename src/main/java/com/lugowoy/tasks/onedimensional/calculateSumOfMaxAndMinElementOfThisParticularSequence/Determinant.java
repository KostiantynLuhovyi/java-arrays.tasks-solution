package com.lugowoy.tasks.onedimensional.calculateSumOfMaxAndMinElementOfThisParticularSequence;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;

/** Created by Konstantin Lugowoy on 01.03.2017. */

@FunctionalInterface
public interface Determinant<T, V> {

    V determine(T t);

    static int determineMaxElement(Array<Integer> array) {
        int result = 0;
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsEqualToOrGreaterThanZero(array.getLength())) {
                for (int i = 0; i < array.getLength(); i++) {
                    if (array.get(i) > result) {
                        result = array.get(i);
                    }
                }
            }
        }
        return result;
    }

    static int determineMinElement(Array<Integer> array) {
        int result = 200;
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsEqualToOrGreaterThanZero(array.getLength())) {
                for (int i = 0; i < array.getLength(); i++) {
                    if (array.get(i) < result) {
                        result = array.get(i);
                    }
                }
            }
        }
        return result;
    }

}
