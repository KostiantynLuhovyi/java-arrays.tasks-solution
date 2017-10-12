package com.lugowoy.tasks.onedimensional.determinePairsOfNumbersFromTheSequenceWhoseSumIsEqualToEnteredNumber;

import com.lugowoy.helper.models.arrays.Array;

/** Created by Konstantin Lugowoy on 19.03.2017. */

public interface Determinable<T> {

    void determine(Array<T> array, int numberForEqual);

    static void determinePairsOfNumbersFromTheSequenceWhoseSumIsEqualToEnteredNumber(Array<Integer> array, int numberForEqual) {
        int countResult = 0;
        for (int i = 0; i < array.getArray().length - 1; i++) {
            for (int j = i + 1; j < array.getArray().length; j++) {
                if ((array.getArray()[i] + array.getArray()[j]) == numberForEqual) {
                    System.out.printf("Element %d , with index %d a plus, element %d, with index %d is equal %d",
                            array.getArray()[i], i, array.getArray()[j], j, numberForEqual);
                    countResult++;
                    System.out.println();
                }
            }
        }
        if (countResult == 0) System.out.println("Not found numbers in a sequence whose sum is equal to the entered number.");
    }

}
