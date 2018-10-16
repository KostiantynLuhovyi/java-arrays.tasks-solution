package com.lugowoy.tasks.onedimensional.determineNumberOfElementsThatAreIdenticalInTwoSequences;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;

/** Created by Konstantin Lugowoy on 30.05.2017. */

@FunctionalInterface
public interface Determinant<T> {

    int determine(T firstT, T secondT);

    static int determineTheNumberOfElementsThatAreIdenticalInTwoSequences(Array<Integer> firstArray, Array<Integer> secondArray) {
        int resultNumberOfIdenticalElements = 0;
        if (CheckerArray.checkArrayNonNull(firstArray) && CheckerArray.checkArrayNonNull(secondArray)) {
            if (CheckerArray.checkLengthOfArrayIsGreaterZero(firstArray.getLength())
                    && CheckerArray.checkLengthOfArrayIsGreaterZero(secondArray.getLength())) {
                for (int i = 0; i < firstArray.getLength(); i++) {
                    for (int j = 0; j < secondArray.getLength(); j++) {
                        if (firstArray.get(i).intValue() == secondArray.get(j).intValue()) {
                            resultNumberOfIdenticalElements++;
                        }
                    }
                }
            }
        }
        return resultNumberOfIdenticalElements;
    }

}
