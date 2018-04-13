package com.lugowoy.tasks.onedimensional.calculateSumOfMaxAndMinElementOfThisParticularSequence;

import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.other.ArrayChecker.checkArrayNonNull;
import static com.lugowoy.helper.other.ArrayChecker.checkLengthOfArrayIsEqualToOrGreaterThanZero;

/** Created by Konstantin Lugowoy on 01.03.2017. */

@FunctionalInterface
public interface Determinant<T, V> {

    V determine(T t);

    static int determineMaxElement(Array<Integer> array) {
        int result = 0;
        try {
            if (checkArrayNonNull(array)) {
                if (checkLengthOfArrayIsEqualToOrGreaterThanZero(array.getLength())) {
                    for (int i = 0; i < array.getLength(); i++) {
                        if (array.get(i) > result) {
                            result = array.get(i);
                        }
                    }
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        return result;
    }

    static int determineMinElement(Array<Integer> array) {
        int result = 200;
        try {
            if (checkArrayNonNull(array)) {
                if (checkLengthOfArrayIsEqualToOrGreaterThanZero(array.getLength())) {
                    for (int i = 0; i < array.getLength(); i++) {
                        if (array.get(i) < result) {
                            result = array.get(i);
                        }
                    }
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        return result;
    }

}
