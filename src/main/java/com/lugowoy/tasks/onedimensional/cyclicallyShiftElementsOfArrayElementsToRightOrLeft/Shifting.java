package com.lugowoy.tasks.onedimensional.cyclicallyShiftElementsOfArrayElementsToRightOrLeft;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;

/** Created by Konstantin Lugowoy on 19.06.2017. */

@FunctionalInterface
public interface Shifting<T> {

    void shift(T t, int numberK);

    static void shiftElementsOfArrayElementsToRightOrLeft(Array<Integer> array, int numberK) {
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsGreaterZero(array.getLength())) {
                if (numberK > 0) {
                    moveRight(array, numberK);
                } else if (numberK < 0) {
                    moveLeft(array, numberK);
                }
            }
        }
    }

    static void moveRight(Array<Integer> array, int numberK) {
        for (int i = 0; i < numberK; i++) {
            int tmp = array.get(array.getLength() - 1);
            System.arraycopy(array.toArray(), 0, array.toArray(), 1, array.getLength() - 1);
            array.set(0, tmp);
        }
    }
    
    static void moveLeft(Array<Integer> array, int numberK) {
        for (int i = 0; i < Math.abs(numberK); i++) {
            int tmp = array.get(0);
            System.arraycopy(array.toArray(), 1, array.toArray(), 0, array.getLength() - 1);
            array.set(array.toArray().length - 1, tmp);
        }
    }

}
