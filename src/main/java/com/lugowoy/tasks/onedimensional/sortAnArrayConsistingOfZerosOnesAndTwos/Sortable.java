package com.lugowoy.tasks.onedimensional.sortAnArrayConsistingOfZerosOnesAndTwos;

import com.lugowoy.helper.models.arrays.Array;

import java.util.Objects;

/** Created by Konstantin Lugowoy on 17.06.2017. */

@FunctionalInterface
public interface Sortable<T> {

    void sort(T t);

    static void sortArray(Array<Integer> array) {
        if (Objects.nonNull(array)) {
            if ((Objects.nonNull(array.getArray())) && (array.getArray().length > 0)) {
                int index = 0;

                for (int i = 0; i < array.getArray().length; i++) {
                    if (array.getArray()[i] == 0) {

                        swapElements(array, index, i);
                        ++index;
                    }
                }

                for (int i = index; i < array.getArray().length; i++) {
                    if (array.getArray()[i] == 1) {

                        swapElements(array, index, i);
                        ++index;
                    }
                }
            }
        }
    }

    static void swapElements(Array<Integer> array, int concreteIndex, int iteratorIndex) {
        int temp = array.getArray()[iteratorIndex];
        array.getArray()[iteratorIndex] = array.getArray()[concreteIndex];
        array.getArray()[concreteIndex] = temp;
    }

}
