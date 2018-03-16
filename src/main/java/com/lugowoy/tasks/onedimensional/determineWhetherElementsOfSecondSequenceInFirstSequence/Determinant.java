package com.lugowoy.tasks.onedimensional.determineWhetherElementsOfSecondSequenceInFirstSequence;

import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayChecker;

import java.util.Objects;

import static com.lugowoy.helper.other.ArrayChecker.*;

/** Created by Konstantin Lugowoy on 12.04.2017. */

@FunctionalInterface
public interface Determinant<T> {

    boolean determine(T tFirst, T tSecond);

    static boolean determineWhetherTheElementsOfTheSecondSequenceInTheFirstSequence(Array<Integer> firstArray,
                                                                                    Array<Integer> secondArray) {
        boolean result = true;
        try {
            if (checkArrayNonNull(firstArray) && checkArrayNonNull(secondArray)) {
                if ((checkArrayNonNull(firstArray.getArray())
                        && checkArrayNonNull(secondArray.getArray()))
                        && (checkLengthOfArrayIsGreaterZero(firstArray.getLength())
                        && checkLengthOfArrayIsGreaterZero(secondArray.getLength()))) {
                    label:
                    for (int i = 0; i < firstArray.getLength(); i++) {
                        for (int j = 0; j < secondArray.getLength(); j++) {
                            if (i == j) continue label;
                            result = false;
                        }
                    }
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        return result;
    }

}
