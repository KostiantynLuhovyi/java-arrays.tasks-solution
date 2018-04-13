package com.lugowoy.tasks.onedimensional.countOfPositiveAndNegativeAndZeroElementsInArray;

import com.lugowoy.helper.models.arrays.Array;

import java.util.Arrays;

import static com.lugowoy.helper.other.ArrayChecker.checkArrayNonNull;
import static com.lugowoy.helper.other.ArrayChecker.checkLengthOfArrayIsGreaterZero;

/** Created by Konstantin Lugowoy on 13-Feb-17. */

@FunctionalInterface
public interface Counting<T extends Number> {

    long count(Array<T> array);

    static long countNegativeNumber(Array<Integer> array) {
        long resultValue = 0;
        try {
            if (checkArrayNonNull(array)) {
                if (checkLengthOfArrayIsGreaterZero(array.getLength())) {
                    resultValue = Math.toIntExact(Arrays.stream(array.toArray(new Integer[array.getLength()]))
                                                        .filter(value -> value < 0)
                                                        .count());
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        return resultValue;
    }

    static long countPositiveNumber(Array<Integer> array) {
        long resultValue = 0;
        try {
            if (checkArrayNonNull(array)) {
                if (checkLengthOfArrayIsGreaterZero(array.getLength())) {
                    resultValue = Math.toIntExact(Arrays.stream(array.toArray(new Integer[array.getLength()]))
                                                        .filter(value -> value > 0)
                                                        .count());
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        return resultValue;
    }

    static long countZero(Array<Integer> array) {
        long resultValue = 0;
        try {
            if (checkArrayNonNull(array)) {
                if (checkLengthOfArrayIsGreaterZero(array.getLength())) {
                    resultValue = Math.toIntExact(Arrays.stream(array.toArray(new Integer[array.getLength()]))
                                                        .filter(value -> value == 0)
                                                        .count());
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        return resultValue;
    }

}
