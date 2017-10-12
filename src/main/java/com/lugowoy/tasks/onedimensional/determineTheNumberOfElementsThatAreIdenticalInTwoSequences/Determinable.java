package com.lugowoy.tasks.onedimensional.determineTheNumberOfElementsThatAreIdenticalInTwoSequences;

import com.lugowoy.helper.models.arrays.Array;

/** Created by Konstantin Lugowoy on 30.05.2017. */

@FunctionalInterface
public interface Determinable<T> {

    int determine(T firstT, T secondT);

    static int determineTheNumberOfElementsThatAreIdenticalInTwoSequences(Array<Integer> firstArray, Array<Integer> secondArray) {
        int resultNumberOfIdenticalElements = 0;

        for (int i = 0; i < firstArray.getArray().length; i++) {
            for (int j = 0; j < secondArray.getArray().length; j++) {
                if (firstArray.getArray()[i].intValue() == secondArray.getArray()[j].intValue()) {
                    resultNumberOfIdenticalElements++;
                }
            }
        }
        return resultNumberOfIdenticalElements;
    }

}
