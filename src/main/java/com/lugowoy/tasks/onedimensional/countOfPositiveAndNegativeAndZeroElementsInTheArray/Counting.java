package com.lugowoy.tasks.onedimensional.countOfPositiveAndNegativeAndZeroElementsInTheArray;

import com.lugowoy.helper.models.arrays.Array;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 13-Feb-17. */

@FunctionalInterface
public interface Counting<T extends Number> {

    int count(Array<T> array);

    static int countNegativeNumber(Array<Integer> array) {
        return Math.toIntExact(Arrays.stream(array.getArray()).filter(value -> value < 0).count());
    }

    static int countPositiveNumber(Array<Integer> array) {
        return Math.toIntExact(Arrays.stream(array.getArray()).filter(value -> value > 0).count());
    }

    static int countZero(Array<Integer> array) {
        return Math.toIntExact(Arrays.stream(array.getArray()).filter(value -> value == 0).count());
    }

}
