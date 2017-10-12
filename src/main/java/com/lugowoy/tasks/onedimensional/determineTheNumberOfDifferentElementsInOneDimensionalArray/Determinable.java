package com.lugowoy.tasks.onedimensional.determineTheNumberOfDifferentElementsInOneDimensionalArray;

import com.lugowoy.helper.models.arrays.Array;

import java.util.Objects;

/** Created by Konstantin Lugowoy on 28.05.2017. */

@FunctionalInterface
public interface Determinable<T extends Number> {

    int determine(Array<T> array);

    static int determineTheNumberOfDifferentElementsInOneDimensionalArray(Array<Integer> array) {
        int resultCountOfDifferentElements = 0;

        if (Objects.nonNull(array)) {
            if ((Objects.nonNull(array.getArray())) && (array.getArray().length > 2)) {
                for (int i = 0; i < array.getArray().length; i++) {
                    if (isUnique(array.getArray()[i], array)) {
                        resultCountOfDifferentElements++;
                    }
                }
            }
        }
        return resultCountOfDifferentElements;
    }

    static boolean isUnique(int number, Array<Integer> array) {
        boolean isUnique = false;
        int countUnique = 0;

        if (Objects.nonNull(array)) {
            if ((Objects.nonNull(array.getArray())) && (array.getArray().length > 2)) {
                if (number >= 0) {
                    for (int i = 0; i < array.getArray().length; i++) {
                        if (number == array.getArray()[i]) {
                            countUnique++;
                        }
                    }
                }
            }
        }

        if (!(countUnique > 1)) {
            isUnique = true;
        }
        return isUnique;
    }

}
