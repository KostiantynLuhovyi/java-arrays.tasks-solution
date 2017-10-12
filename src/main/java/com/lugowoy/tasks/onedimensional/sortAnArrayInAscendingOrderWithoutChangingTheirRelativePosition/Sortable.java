package com.lugowoy.tasks.onedimensional.sortAnArrayInAscendingOrderWithoutChangingTheirRelativePosition;

import com.lugowoy.helper.models.arrays.Array;

/** Created by Konstantin Lugowoy on 14.05.2017. */

@FunctionalInterface
public interface Sortable<T> {

    void sort(Array<T> array);

    static void sortAnArrayInAscendingOrderWithoutChangingTheirRelativePosition(Array<Integer> array) {
        int tmp;

        for (int i = 0; i < array.getArray().length; i++) {
            for (int j = 0; j < array.getArray().length - i - 1; j++) {
                if (((array.getArray()[j] == 0) && (array.getArray()[j + 1] < 0))
                        || ((array.getArray()[j] > 0) && (array.getArray()[j + 1] <= 0 ))) {
                    tmp = array.getArray()[j];
                    array.getArray()[j] = array.getArray()[j + 1];
                    array.getArray()[j + 1] = tmp;
                }
            }
        }
    }
}
