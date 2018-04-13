package com.lugowoy.tasks.onedimensional.compareMultiplicationModulesOfPositiveAndNegativeNumbers.multiplicate;

import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.other.ArrayChecker.checkArrayNonNull;
import static com.lugowoy.helper.other.ArrayChecker.checkLengthOfArrayIsEqualToOrGreaterThanZero;

/** Created by Konstantin Lugowoy on 11.03.2017. */

public class MultiplicationPositiveNumbers {

    public static int multiplication(Array<Integer> array) {
        int resultMultiplication = 1;
        try {
            if (checkArrayNonNull(array)) {
                if (checkLengthOfArrayIsEqualToOrGreaterThanZero(array.getLength())) {
                    for (int i = 0; i < array.getLength(); i++) {
                        if (array.get(i) > 0) {
                            resultMultiplication *= array.get(i);
                        }
                    }
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        return resultMultiplication;
    }

}
