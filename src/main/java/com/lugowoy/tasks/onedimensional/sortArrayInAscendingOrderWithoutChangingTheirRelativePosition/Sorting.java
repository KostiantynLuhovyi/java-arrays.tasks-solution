package com.lugowoy.tasks.onedimensional.sortArrayInAscendingOrderWithoutChangingTheirRelativePosition;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;

/** Created by Konstantin Lugowoy on 14.05.2017. */

@FunctionalInterface
public interface Sorting<T> {

    void sort(Array<T> array);

    static void sortAnArrayInAscendingOrderWithoutChangingTheirRelativePosition(Array<Integer> array) {
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsGreaterZero(array.getLength())) {
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
    }

}
