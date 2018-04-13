package com.lugowoy.tasks.onedimensional.changeSequenceByMultiplyingElementsBySquareOfMinAndMaxNumbersByRule;

import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.other.ArrayChecker.checkArrayNonNull;
import static com.lugowoy.helper.other.ArrayChecker.checkLengthOfArrayIsGreaterZero;

/** Created by Konstantin Lugowoy on 25.03.2017. */

@FunctionalInterface
public interface Changing<T, V> {

    void change(T t, V firstArg, V secondArg);

    static void changeSequenceByMultiplyingElementsBySquareOfMinAndMaxNumberByRule(Array<Integer> array, int squareMinNumber,
                                                                                                         int squareMaxNumber) {
        try {
            if (checkArrayNonNull(array)) {
                if (checkLengthOfArrayIsGreaterZero(array.getLength())) {
                    for (int i = 0; i < array.getLength(); i++) {
                        if (array.get(i) >= 0) {
                            array.set(i, array.get(i) * squareMinNumber);
                        } else if (array.get(i) <= 0) {
                            array.set(i, array.get(i) * squareMaxNumber);
                        }
                    }
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
