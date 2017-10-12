package com.lugowoy.tasks.onedimensional.calculateTheSumOfArrayElementsLocatedBetweenTheMinAndMaxElementsInclusive;

import com.lugowoy.helper.models.arrays.Array;

/** Created by Konstantin Lugowoy on 27.03.2017. */

@FunctionalInterface
public interface Determinable {

    int determine(Array<Integer> array);

    static int determineMinElementIndex(Array<Integer> array) {
        int indexMinElement = 0, valueForDetermineMinElementIndex = Integer.MAX_VALUE;
            if (array != null) {
                if ((array.getArray() != null) && (array.getArray().length > 0)) {
                    for (int i = 0; i < array.getArray().length; i++) {
                        if (array.getArray()[i] < valueForDetermineMinElementIndex) {
                        valueForDetermineMinElementIndex = array.getArray()[i];
                        indexMinElement = i;
                        }
                    }
                } else {
                    System.out.println("The array is not valid for any operations or calculations.");
                }
            } else {
                System.out.println("The array is not valid for any operations or calculations.");
            }
        return indexMinElement;
    }

    static int determineMaxElementIndex(Array<Integer> array) {
        int indexMaxElement = 0, valueForDetermineMaxElementIndex = Integer.MIN_VALUE;
        if (array != null) {
            if ((array.getArray() != null) && (array.getArray().length > 0)) {
                for (int i = 0; i < array.getArray().length; i++) {
                    if (array.getArray()[i] > valueForDetermineMaxElementIndex) {
                        valueForDetermineMaxElementIndex = array.getArray()[i];
                        indexMaxElement = i;
                    }
                }
            } else {
                System.out.println("The array is not valid for any operations or calculations.");
            }
        } else {
            System.out.println("The array is not valid for any operations or calculations.");
        }
        return indexMaxElement;
    }

}
