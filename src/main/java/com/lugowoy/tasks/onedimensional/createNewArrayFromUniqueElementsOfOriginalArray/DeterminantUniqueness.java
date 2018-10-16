package com.lugowoy.tasks.onedimensional.createNewArrayFromUniqueElementsOfOriginalArray;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;

/** Created by Konstantin Lugowoy on 29.05.2017. */

@FunctionalInterface
public interface DeterminantUniqueness {

    int CRITICAL_COUNT_UNIQUE = 2;

    Array<Integer> determineUniqueness(Array<Integer> array);

    static Array<Integer> determineTheUniqueElementsOfTheOriginalArray(Array<Integer> array) {
        Array<Integer> tmpArray = Array.create(0);
        int countUnique = 0;
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsGreaterZero(array.getLength())) {
                for (int i = 0; i < array.getLength(); i++) {
                    for (int j = 0; j < array.getLength(); j++) {
                        if ((array.get(i).equals(array.get(j)))) {
                            countUnique++;
                        }
                    }
                    if (countUnique < CRITICAL_COUNT_UNIQUE) {
                        tmpArray.add(array.get(i));
                    }
                    countUnique = 0;
                }
            }
        }
        return tmpArray;
    }

}
