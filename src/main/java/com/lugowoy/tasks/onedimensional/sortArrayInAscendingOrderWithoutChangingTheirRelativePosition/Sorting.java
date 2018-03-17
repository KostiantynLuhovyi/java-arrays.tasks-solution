package com.lugowoy.tasks.onedimensional.sortArrayInAscendingOrderWithoutChangingTheirRelativePosition;

import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayChecker;

/** Created by Konstantin Lugowoy on 14.05.2017. */

@FunctionalInterface
public interface Sorting<T> {

    void sort(Array<T> array);

    static void sortAnArrayInAscendingOrderWithoutChangingTheirRelativePosition(Array<Integer> array) {
        try {
            if (ArrayChecker.checkArrayNonNull(array)) {
                if (ArrayChecker.checkArrayNonNull(array.getArray()) && ArrayChecker.checkLengthOfArrayIsGreaterZero(array.getLength())) {
                    int tmp;
                    for (int i = 0; i < array.getLength(); i++) {
                        for (int j = 0; j < array.getLength() - i - 1; j++) {
                            if (((array.get(j) == 0) && (array.get(j + 1) < 0))
                                    || ((array.get(j) > 0) && (array.get(j + 1) <= 0))) {
                                tmp = array.get(j);
                                array.set(j, array.get(j + 1));
                                array.set(j + 1, tmp);
                            }
                        }
                    }
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
