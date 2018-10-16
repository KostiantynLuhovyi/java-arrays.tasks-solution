package com.lugowoy.tasks.onedimensional.determinePairsOfNumbersFromSequenceWhoseSumIsEqualToEnteredNumber;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;

/** Created by Konstantin Lugowoy on 19.03.2017. */

public interface Determinant<T> {

    void determine(Array<T> array, int numberForEqual);

    static void determinePairsOfNumbersFromTheSequenceWhoseSumIsEqualToEnteredNumber(Array<Integer> array, int numberForEqual) {
        int countResult = 0;
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsGreaterZero(array.getLength())) {
                for (int i = 0; i < array.getLength() - 1; i++) {
                    for (int j = i + 1; j < array.getLength(); j++) {
                        if ((array.get(i) + array.get(j)) == numberForEqual) {
                            System.out.printf("Element %d , with index %d a plus, element %d, with index %d is equal %d",
                                                                        array.get(i), i, array.get(j), j, numberForEqual);
                            countResult++;
                            System.out.println();
                        }
                    }
                }
            }
        }
        if (countResult == 0) System.out.println("Not found numbers in a sequence whose sum is equal to the entered number.");
    }

}
