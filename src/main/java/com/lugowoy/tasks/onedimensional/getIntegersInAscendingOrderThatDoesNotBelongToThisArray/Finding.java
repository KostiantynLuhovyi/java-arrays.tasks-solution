package com.lugowoy.tasks.onedimensional.getIntegersInAscendingOrderThatDoesNotBelongToThisArray;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;

import java.util.Arrays;
import java.util.Collections;

/** Created by Konstantin Lugowoy on 11.04.2017. */

public interface Finding<T, V> {

    T find(V v);

    static int findMaxNumber(Array<Integer> array) {
        int resultValueOfMaxNumber = 0;
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsGreaterZero(array.getLength())) {
                resultValueOfMaxNumber = Collections.max(Arrays.asList(array.toArray(new Integer[array.getLength()])));
            }
        }
        return resultValueOfMaxNumber;
    }

    static int findMinNumber(Array<Integer> array) {
        int resultValueOfMinNumber = 0;
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsGreaterZero(array.getLength())) {
                resultValueOfMinNumber = Collections.min(Arrays.asList(array.toArray(new Integer[array.getLength()])));
            }
        }
        return resultValueOfMinNumber;
    }

}
