package com.lugowoy.tasks.onedimensional.compareMultiplicationModulesOfPositiveAndNegativeNumbers.multiplicate;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;

/** Created by Konstantin Lugowoy on 11.03.2017. */

public class MultiplicationPositiveNumbers {

    public static int multiplication(Array<Integer> array) {
        int resultMultiplication = 1;
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsEqualToOrGreaterThanZero(array.getLength())) {
                for (int i = 0; i < array.getLength(); i++) {
                    if (array.get(i) > 0) {
                        resultMultiplication *= array.get(i);
                    }
                }
            }
        }
        return resultMultiplication;
    }

}
