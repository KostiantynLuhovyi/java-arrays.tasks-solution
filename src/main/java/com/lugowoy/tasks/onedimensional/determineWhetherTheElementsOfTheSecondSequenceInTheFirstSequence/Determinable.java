package com.lugowoy.tasks.onedimensional.determineWhetherTheElementsOfTheSecondSequenceInTheFirstSequence;

import com.lugowoy.helper.models.arrays.Array;

import java.util.Objects;

/** Created by Konstantin Lugowoy on 12.04.2017. */

@FunctionalInterface
public interface Determinable<T> {

    boolean determine(T tFirst, T tSecond);

    static boolean determineWhetherTheElementsOfTheSecondSequenceInTheFirstSequence(Array<Integer> firstArray, Array<Integer> secondArray) {
        boolean result = true;
        if ((Objects.nonNull(firstArray)) && (Objects.nonNull(secondArray))) {
            if (((Objects.nonNull(firstArray.getArray())) && (Objects.nonNull(secondArray.getArray())))
                    && ((firstArray.getArray().length > 0) && (secondArray.getArray().length > 0))) {
                label:
                for (int i : firstArray.getArray()) {
                    for (int j : secondArray.getArray())
                        if (i == j) continue label;
                    result = false;
                }
            }
        }
        return result;
    }

}
