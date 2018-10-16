package com.lugowoy.tasks.onedimensional.divideOriginalArrayInToEvenAndOddArray;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;

/** Created by Konstantin Lugowoy on 16.03.2017. */

public interface Selecting<T> {

    int STATUS_EVEN_NUMBERS = 1;
    int STATUS_ODD_NUMBERS = 0;

    T select(T t, int statusNumbers);

    static Array<Integer> selectArray(Array<Integer> array, int statusNumbers) {
        Array<Integer> tmpArray = Array.create(0);
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsGreaterZero(array.getLength())) {
                if (statusNumbers == STATUS_EVEN_NUMBERS) {
                    for (int i = 0; i < array.getLength(); i++) {
                        if (array.get(i) != null) {
                            if (array.get(i) % 2 == 0) {
                                tmpArray.add(array.get(i));
                            }
                        }
                    }
                } else if (statusNumbers == STATUS_ODD_NUMBERS) {
                    for (int i = 0; i < array.getLength(); i++) {
                        if (array.get(i) != null) {
                            if (array.get(i) % 2 != 0) {
                                tmpArray.add(array.get(i));
                            }
                        }
                    }
                }
            }
        }
        return tmpArray;
    }

}
