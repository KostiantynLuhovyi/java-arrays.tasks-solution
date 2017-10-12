package com.lugowoy.tasks.onedimensional.changeSequenceByMultiplyingTheElementsByTheSquareOfTheMinAndMaxNumbersByRule;

import com.lugowoy.helper.models.arrays.Array;

import java.util.Objects;

/** Created by Konstantin Lugowoy on 25.03.2017. */

@FunctionalInterface
public interface Changeable<T, V> {

    void change(T t, V firstArg, V secondArg);

    static void changeSequenceByMultiplyingTheElementsByTheSquareOfTheMinAndMaxNumberByRule(Array<Integer> array, int squareMinNumber, int squareMaxNumber) {
        if (Objects.nonNull(array)) {
            if ((Objects.nonNull(array.getArray()) && (array.getArray().length > 0))) {
                for (int i = 0; i < array.getArray().length; i++) {
                    if (array.getArray()[i] >= 0) {
                        array.getArray()[i] *= squareMinNumber;
                    } else if (array.getArray()[i] <= 0) {
                        array.getArray()[i] *= squareMaxNumber;
                    }
                }
            } else {
                System.out.println("The array is not valid for any operations or calculations.");
            }
        } else {
            System.out.println("The array is not valid for any operations or calculations.");
        }
    }

}
