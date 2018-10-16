package com.lugowoy.tasks.onedimensional.determineNumberOfDifferentElementsInOneDimensionalArray;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;

/** Created by Konstantin Lugowoy on 28.05.2017. */

@FunctionalInterface
public interface Determinant<T extends Number> {

    int determine(Array<T> array);

    static int determineTheNumberOfDifferentElementsInOneDimensionalArray(Array<Integer> array) {
        int resultCountOfDifferentElements = 0;
        if (CheckerArray.checkArrayNonNull(array)) {
            if (array.getLength() > 2) {
                for (int i = 0; i < array.getLength(); i++) {
                    if (isUnique(array.get(i), array)) {
                        resultCountOfDifferentElements++;
                    }
                }
            }
        }
        return resultCountOfDifferentElements;
    }

    private static boolean isUnique(int number, Array<Integer> array) {
        boolean isUnique = false;
        int countUnique = 0;
        if (CheckerArray.checkArrayNonNull(array)) {
            if (array.getLength() > 2) {
                if (number >= 0) {
                    for (int i = 0; i < array.getLength(); i++) {
                        if (number == array.get(i)) {
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
