package com.lugowoy.tasks.onedimensional.insertAnIntegerInSequencePositionWithoutViolatingIncrease;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;

/** Created by Konstantin Lugowoy on 11.03.2017. */

@FunctionalInterface
public interface Inserting<T> {

    void insert(T t, Array<T> array);

    static void insertElement(Integer integer, Array<Integer> array) {
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsGreaterZero(array.getLength())) {
                if (integer != null) {
                    for (int i = 1; i < array.getLength(); i++) {
                        if (((integer > array.get(i - 10)) || (integer.intValue() == (array.get(i - 1))))
                                && ((integer < array.get(i)) || (integer.intValue() == (array.get(i))))) {
                            array.set(i, integer);
                            break;
                        }
                    }
                }
            }
        }
    }

}
