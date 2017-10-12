package com.lugowoy.tasks.onedimensional.changeSequenceByMultiplyingTheElementsByTheSquareOfTheMinAndMaxNumbersByRule;

import com.lugowoy.helper.models.arrays.Array;

import java.util.Objects;

/** Created by Konstantin Lugowoy on 25.03.2017. */

public interface Findable<T> {

    T find(Array<T> array);

    static Integer findMinNumber(Array<Integer> array) {
        int valueForDetermineMinNumber = Integer.MAX_VALUE;
        int indexMinNumber = 0, resultFindMinNumber;

        if (Objects.nonNull(array)) {
            if ((Objects.nonNull(array.getArray()) && (array.getArray().length > 0))) {
                for (int i = 0; i < array.getArray().length; i++) {
                    if (array.getArray()[i] <= valueForDetermineMinNumber) {
                        valueForDetermineMinNumber = array.getArray()[i];
                        indexMinNumber = i;
                    }
                }
            } else {
                System.out.println("The array is not valid for any operations or calculations.");
            }
        } else {
            System.out.println("The array is not valid for any operations or calculations.");
        }
        resultFindMinNumber = array.getArray()[indexMinNumber];

        return resultFindMinNumber;
    }

    static Integer findMaxNumber(Array<Integer> array) {
        int valueForDetermineMaxNumber = Integer.MIN_VALUE;
        int indexMaxNumber = 0, resultFindMaxNumber;

        if (Objects.nonNull(array)) {
            if ((Objects.nonNull(array.getArray())) && (array.getArray().length > 0)) {
                for (int i = 0; i < array.getArray().length; i++) {
                    if (array.getArray()[i] >= valueForDetermineMaxNumber) {
                        valueForDetermineMaxNumber = array.getArray()[i];
                        indexMaxNumber = i;
                    }
                }
            } else {
                System.out.println("The array is not valid for any operations or calculations.");
            }
        } else {
            System.out.println("The array is not valid for any operations or calculations.");
        }
        resultFindMaxNumber = array.getArray()[indexMaxNumber];

        return resultFindMaxNumber;
    }

}
