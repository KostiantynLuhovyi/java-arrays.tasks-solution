package com.lugowoy.tasks.onedimensional.determineNumberOfDifferentElementsInOneDimensionalArray;

import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.other.ArrayChecker.checkArrayNonNull;

/** Created by Konstantin Lugowoy on 28.05.2017. */

@FunctionalInterface
public interface Determinant<T extends Number> {

    int determine(Array<T> array);

    static int determineTheNumberOfDifferentElementsInOneDimensionalArray(Array<Integer> array) {
        int resultCountOfDifferentElements = 0;
        try {
            if (checkArrayNonNull(array)) {
                if ((checkArrayNonNull(array.getArray())) && (array.getArray().length > 2)) {
                    for (int i = 0; i < array.getArray().length; i++) {
                        if (isUnique(array.getArray()[i], array)) {
                            resultCountOfDifferentElements++;
                        }
                    }
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        return resultCountOfDifferentElements;
    }

    static boolean isUnique(int number, Array<Integer> array) {
        boolean isUnique = false;
        int countUnique = 0;

        try {
            if (checkArrayNonNull(array)) {
                if ((checkArrayNonNull(array.getArray())) && (array.getArray().length > 2)) {
                    if (number >= 0) {
                        for (int i = 0; i < array.getArray().length; i++) {
                            if (number == array.getArray()[i]) {
                                countUnique++;
                            }
                        }
                    }
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }

        if (!(countUnique > 1)) {
            isUnique = true;
        }
        return isUnique;
    }

}
