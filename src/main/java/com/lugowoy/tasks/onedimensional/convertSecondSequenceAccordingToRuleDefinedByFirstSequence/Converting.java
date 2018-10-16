package com.lugowoy.tasks.onedimensional.convertSecondSequenceAccordingToRuleDefinedByFirstSequence;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;

/** Created by Konstantin Lugowoy on 25.03.2017. */

@FunctionalInterface
public interface Converting<T> {

    void convert(Array<T> firstArray, Array<T> secondArray);
    
    static void convertSecondSequenceAccordingToRuleDefinedByFirstSequence(Array<Integer> firstArray, Array<Integer> secondArray) {
        if (CheckerArray.checkArrayNonNull(firstArray) && CheckerArray.checkArrayNonNull(secondArray)) {
            if (CheckerArray.checkLengthOfArrayIsGreaterZero(firstArray.getLength())
                    && CheckerArray.checkLengthOfArrayIsGreaterZero(secondArray.getLength())) {
                if (firstArray.getLength() == secondArray.getLength()) {
                    for (int i = 0; i < firstArray.getLength(); i++) {
                        if (firstArray.get(i) <= 0) {
                            secondArray.set(i, secondArray.get(i) * 10);
                        } else {
                            secondArray.set(i, 0);
                        }
                    }
                } else {
                    System.err.println("Sequences sizes are not equal.");
                }
            }
        }
    }

}
