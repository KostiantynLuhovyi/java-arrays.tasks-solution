package com.lugowoy.tasks.onedimensional.cyclicallyShiftElementsOfArrayElementsToRightOrLeft;

import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.other.ArrayChecker.checkArrayNonNull;
import static com.lugowoy.helper.other.ArrayChecker.checkLengthOfArrayIsGreaterZero;
import static java.lang.Math.abs;

/** Created by Konstantin Lugowoy on 19.06.2017. */

@FunctionalInterface
public interface Shifting<T> {

    void shift(T t, int numberK);

    static void shiftElementsOfArrayElementsToRightOrLeft(Array<Integer> array, int numberK) {
        try {
            if (checkArrayNonNull(array)) {
                if (checkLengthOfArrayIsGreaterZero(array.getLength())) {
                    if (numberK > 0) {
                        moveRight(array, numberK);
                    } else if (numberK < 0) {
                        moveLeft(array, numberK);
                    }
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
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
        for (int i = 0; i < abs(numberK); i++) {
            int tmp = array.get(0);

            System.arraycopy(array.toArray(), 1, array.toArray(), 0, array.getLength() - 1);

            array.set(array.toArray().length - 1, tmp);
        }
    }

}
