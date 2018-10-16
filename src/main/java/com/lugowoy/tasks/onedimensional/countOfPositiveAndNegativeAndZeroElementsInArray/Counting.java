package com.lugowoy.tasks.onedimensional.countOfPositiveAndNegativeAndZeroElementsInArray;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 13-Feb-17. */

@FunctionalInterface
public interface Counting<T extends Number> {

    long count(Array<T> array);

    static long countNegativeNumber(Array<Integer> array) {
        long resultValue = 0;
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsGreaterZero(array.getLength())) {
                resultValue = Math.toIntExact(Arrays.stream(array.toArray(new Integer[array.getLength()]))
                        .filter(value -> value < 0)
                        .count());
            }
        }
        return resultValue;
    }

    static long countPositiveNumber(Array<Integer> array) {
        long resultValue = 0;
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsGreaterZero(array.getLength())) {
                resultValue = Math.toIntExact(Arrays.stream(array.toArray(new Integer[array.getLength()]))
                                                    .filter(value -> value > 0)
                                                    .count());
            }
        }
        return resultValue;
    }

    static long countZero(Array<Integer> array) {
        long resultValue = 0;
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsGreaterZero(array.getLength())) {
                resultValue = Math.toIntExact(Arrays.stream(array.toArray(new Integer[array.getLength()]))
                                                    .filter(value -> value == 0)
                                                    .count());
            }
        }
        return resultValue;
    }

}
