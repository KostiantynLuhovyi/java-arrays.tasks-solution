package com.lugowoy.tasks.onedimensional.cyclicallyShiftElementsOfArrayElementsKtoRightOrLeft;

import com.lugowoy.helper.models.arrays.Array;

import java.util.Objects;

import static java.lang.Math.abs;

/** Created by Konstantin Lugowoy on 19.06.2017. */

@FunctionalInterface
public interface Shiftable<T> {

    void shift(T t, int numberK);

    static void shiftElementsOfArrayElementsToRightOrLeft(Array<Integer> array, int numberK) {
        if (Objects.nonNull(array)) {
            if ((Objects.nonNull(array.getArray())) && (array.getArray().length > 0)) {
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
            int tmp = array.getArray()[array.getArray().length - 1];

            System.arraycopy(array.getArray(), 0, array.getArray(), 1, array.getArray().length - 1);

            array.getArray()[0] = tmp;
        }
    }
    
    static void moveLeft(Array<Integer> array, int numberK) {
        for (int i = 0; i < abs(numberK); i++) {
            int tmp = array.getArray()[0];

            System.arraycopy(array.getArray(), 1, array.getArray(), 0, array.getArray().length - 1);

            array.getArray()[array.getArray().length - 1] = tmp;
        }
    }

}
