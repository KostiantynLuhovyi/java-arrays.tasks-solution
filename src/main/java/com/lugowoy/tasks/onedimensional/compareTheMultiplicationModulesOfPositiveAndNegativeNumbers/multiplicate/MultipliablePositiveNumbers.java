package com.lugowoy.tasks.onedimensional.compareTheMultiplicationModulesOfPositiveAndNegativeNumbers.multiplicate;

import com.lugowoy.helper.models.arrays.Array;

import java.util.Objects;

/** Created by Konstantin Lugowoy on 11.03.2017. */

public class MultipliablePositiveNumbers {

    public static Integer multiplication(Array<Integer> array) {
        Integer resultMultiplication = 1;
        if (Objects.nonNull(array)) {
            if ((Objects.nonNull(array.getArray())) && (array.getArray().length > 0)) {
                for (Integer integer : array.getArray()) {
                    if (integer > 0) {
                        resultMultiplication *= integer;
                    }
                }
            } else {
                System.out.println("The array is not valid for any operations or calculations.");
            }
        } else {
            System.out.println("The array is not valid for any operations or calculations.");
        }
        return resultMultiplication;
    }

}
