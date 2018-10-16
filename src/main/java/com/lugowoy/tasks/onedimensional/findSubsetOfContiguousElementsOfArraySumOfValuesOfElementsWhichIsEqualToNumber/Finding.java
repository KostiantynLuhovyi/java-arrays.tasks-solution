package com.lugowoy.tasks.onedimensional.findSubsetOfContiguousElementsOfArraySumOfValuesOfElementsWhichIsEqualToNumber;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 18.06.2017. */

@FunctionalInterface
public interface Finding<T, V> {

    V[] find(T t, V vNumber);

    static Integer[] findSubsetOfContiguousElementsOfArraySumOfValuesOfElementsWhichIsEqualToNumber(Array<Integer> array, Integer number) {
        Integer[] resultArray = null;
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsEqualToOrGreaterThanZero(array.getLength())) {
                int sum = array.get(0);
                int i = 0, j = 1;
                while (j < array.getLength()) {
                    if (sum < number) {
                        sum += array.get(j++);
                    } else if (sum > number) {
                        sum -= array.get(i++);
                    } else {
                        resultArray = Arrays.copyOfRange(array.toArray(new Integer[array.getLength()]), i, j);
                        break;
                    }
                }
            }
        }
        return resultArray;
    }

}
