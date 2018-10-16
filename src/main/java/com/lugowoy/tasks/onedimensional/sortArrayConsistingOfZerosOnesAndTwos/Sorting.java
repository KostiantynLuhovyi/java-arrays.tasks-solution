package com.lugowoy.tasks.onedimensional.sortArrayConsistingOfZerosOnesAndTwos;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;

/** Created by Konstantin Lugowoy on 17.06.2017. */

@FunctionalInterface
public interface Sorting<T> {

    void sort(T t);

    static void sortArray(Array<Integer> array) {
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsGreaterZero(array.getLength())) {
                int index = 0;
                for (int i = 0; i < array.getLength(); i++) {
                    if (array.get(i) == 0) {
                        swapElements(array, index, i);
                        ++index;
                    }
                }
                for (int i = index; i < array.getLength(); i++) {
                    if (array.get(i) == 1) {
                        swapElements(array, index, i);
                        ++index;
                    }
                }
            }
        }
    }

    static void swapElements(Array<Integer> array, int concreteIndex, int iteratorIndex) {
        int temp = array.get(iteratorIndex);
        array.set(iteratorIndex, array.get(concreteIndex));
        array.set(concreteIndex, temp);
    }

}
