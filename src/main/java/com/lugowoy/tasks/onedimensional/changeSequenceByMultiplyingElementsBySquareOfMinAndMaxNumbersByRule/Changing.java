package com.lugowoy.tasks.onedimensional.changeSequenceByMultiplyingElementsBySquareOfMinAndMaxNumbersByRule;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;

/** Created by Konstantin Lugowoy on 25.03.2017. */

@FunctionalInterface
public interface Changing<T, V> {

    void change(T t, V firstArg, V secondArg);

    static void changeSequenceByMultiplyingElementsBySquareOfMinAndMaxNumberByRule(Array<Integer> array, int squareMinNumber,
                                                                                                         int squareMaxNumber) {
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsGreaterZero(array.getLength())) {
                for (int i = 0; i < array.getLength(); i++) {
                    if (array.get(i) >= 0) {
                        array.set(i, array.get(i) * squareMinNumber);
                    } else if (array.get(i) <= 0) {
                        array.set(i, array.get(i) * squareMaxNumber);
                    }
                }
            }
        }
    }

}
