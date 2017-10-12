package com.lugowoy.tasks.onedimensional.determineElementsThatAreEqualToHalfSumOfNeighboringElements;

import com.lugowoy.helper.models.arrays.Array;

import java.util.Objects;

/** Created by Konstantin Lugowoy on 03.09.2017. */

@FunctionalInterface
public interface Determinator {

    void determine(Array<Integer> array);

    static void determineElementsThatAreEqualToHalfSumOfNeighboringElements(Array<Integer> array) {
        if (Objects.nonNull(array)) {
            if ((Objects.nonNull(array.getArray())) && (array.getArray().length > 2)) {
                int counterCoincidence = 0;
                for (int i = 1; i < array.getArray().length - 1; i++) {
                    if (((array.getArray()[i - 1] + array.getArray()[i + 1]) / 2) == array.getArray()[i]) {
                        System.out.printf("Element %d at index %d is equal to half sum element %d at index %d and element %d at index %d.",
                                            array.getArray()[i], i, array.getArray()[i - 1], i - 1, array.getArray()[i + 1], i + 1);
                        System.out.println();
                        counterCoincidence++;
                    }
                }
                if (counterCoincidence == 0) {
                    System.out.println("No items found that satisfied the condition.");
                }
            }
        }
    }

}
