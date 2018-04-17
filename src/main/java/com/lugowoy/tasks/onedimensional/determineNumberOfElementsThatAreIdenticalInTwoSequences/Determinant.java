package com.lugowoy.tasks.onedimensional.determineNumberOfElementsThatAreIdenticalInTwoSequences;

import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.other.ArrayChecker.checkArrayNonNull;
import static com.lugowoy.helper.other.ArrayChecker.checkLengthOfArrayIsGreaterZero;

/** Created by Konstantin Lugowoy on 30.05.2017. */

@FunctionalInterface
public interface Determinant<T> {

    int determine(T firstT, T secondT);

    static int determineTheNumberOfElementsThatAreIdenticalInTwoSequences(Array<Integer> firstArray, Array<Integer> secondArray) {
        int resultNumberOfIdenticalElements = 0;
        try {
            if (checkArrayNonNull(firstArray) && checkArrayNonNull(secondArray)) {
                if (checkLengthOfArrayIsGreaterZero(firstArray.getLength())
                        && checkLengthOfArrayIsGreaterZero(secondArray.getLength())) {
                    for (int i = 0; i < firstArray.getLength(); i++) {
                        for (int j = 0; j < secondArray.getLength(); j++) {
                            if (firstArray.get(i).intValue() == secondArray.get(j).intValue()) {
                                resultNumberOfIdenticalElements++;
                            }
                        }
                    }
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        return resultNumberOfIdenticalElements;
    }

}
