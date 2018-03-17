package com.lugowoy.tasks.onedimensional.findSubsetOfContiguousElementsOfArraySumOfValuesOfElementsWhichIsEqualToNumber;

import com.lugowoy.helper.models.arrays.Array;

import java.util.Arrays;

import static com.lugowoy.helper.other.ArrayChecker.checkArrayNonNull;
import static com.lugowoy.helper.other.ArrayChecker.checkLengthOfArrayIsEqualToOrGreaterThanZero;

/** Created by Konstantin Lugowoy on 18.06.2017. */

@FunctionalInterface
public interface Finding<T, V> {

    V[] find(T t, V vNumber);

    static Integer[] findSubsetOfContiguousElementsOfArraySumOfValuesOfElementsWhichIsEqualToNumber(Array<Integer> array, Integer number) {
        Integer[] resultArray = null;
        try {
            if (checkArrayNonNull(array)) {
                if (checkArrayNonNull(array.getArray()) && checkLengthOfArrayIsEqualToOrGreaterThanZero(array.getLength())) {
                    int sum = array.get(0);
                    int i = 0, j = 1;

                    while (j < array.getLength()) {
                        if (sum < number) {
                            sum += array.get(j++);

                        } else if (sum > number) {
                            sum -= array.get(i++);
                        } else {
                            resultArray = Arrays.copyOfRange(array.getArray(), i, j);
                            break;
                        }
                    }
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        return resultArray;
    }

}
