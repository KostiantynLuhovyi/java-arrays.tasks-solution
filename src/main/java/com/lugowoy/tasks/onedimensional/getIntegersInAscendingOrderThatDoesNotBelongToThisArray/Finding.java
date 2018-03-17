package com.lugowoy.tasks.onedimensional.getIntegersInAscendingOrderThatDoesNotBelongToThisArray;

import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayChecker;

import java.util.Arrays;
import java.util.Collections;

import static com.lugowoy.helper.other.ArrayChecker.*;

/** Created by Konstantin Lugowoy on 11.04.2017. */

public interface Finding<T, V> {

    T find(V v);

    static int findMaxNumber(Array<Integer> array) {
        int resultValueOfMaxNumber = 0;
        try {
            if (checkArrayNonNull(array)) {
                if (checkArrayNonNull(array.getArray()) && checkLengthOfArrayIsGreaterZero(array.getLength())) {
                    resultValueOfMaxNumber = Collections.max(Arrays.asList(array.getArray()));
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        return resultValueOfMaxNumber;
    }

    static int findMinNumber(Array<Integer> array) {
        int resultValueOfMinNumber = 0;
        try {
            if (checkArrayNonNull(array)) {
                if (checkArrayNonNull(array.getArray()) && checkLengthOfArrayIsGreaterZero(array.getLength())) {
                    resultValueOfMinNumber = Collections.min(Arrays.asList(array.getArray()));
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        return resultValueOfMinNumber;
    }

}
