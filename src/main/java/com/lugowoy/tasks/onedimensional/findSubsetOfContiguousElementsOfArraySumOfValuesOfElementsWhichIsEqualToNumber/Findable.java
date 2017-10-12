package com.lugowoy.tasks.onedimensional.findSubsetOfContiguousElementsOfArraySumOfValuesOfElementsWhichIsEqualToNumber;

import com.lugowoy.helper.models.arrays.Array;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 18.06.2017. */

@FunctionalInterface
public interface Findable<T, V> {

    V[] find(T t, V vNumber);

    static Integer[] findSubsetOfContiguousElementsOfArraySumOfValuesOfElementsWhichIsEqualToNumber(Array<Integer> array, Integer number) {
        Integer[] resultArray = null;

        int sum = array.getArray()[0];
        int i = 0, j = 1;

        while (j < array.getArray().length) {
            if (sum < number) {
                sum += array.getArray()[j++];

            } else if (sum > number) {
                sum -= array.getArray()[i++];
            } else {
                resultArray = Arrays.copyOfRange(array.getArray(), i, j);
                break;
            }
        }
        return resultArray;
    }

}
