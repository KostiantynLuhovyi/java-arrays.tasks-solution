package com.lugowoy.tasks.onedimensional.convertSecondSequenceAccordingToRuleDefinedByFirstSequence;

import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.other.ArrayChecker.checkArrayNonNull;
import static com.lugowoy.helper.other.ArrayChecker.checkLengthOfArrayIsGreaterZero;

/** Created by Konstantin Lugowoy on 25.03.2017. */

@FunctionalInterface
public interface Converting<T> {

    void convert(Array<T> firstArray, Array<T> secondArray);
    
    static void convertSecondSequenceAccordingToRuleDefinedByFirstSequence(Array<Integer> firstArray, Array<Integer> secondArray) {
        try {
            if (checkArrayNonNull(firstArray) && checkArrayNonNull(secondArray)) {
                if ((checkArrayNonNull(firstArray.getArray()) && checkArrayNonNull(secondArray.getArray()))
                        && (checkLengthOfArrayIsGreaterZero(firstArray.getLength()) && checkLengthOfArrayIsGreaterZero(secondArray.getLength()))) {
                    if (firstArray.getLength() == secondArray.getLength()) {
                        for (int i = 0; i < firstArray.getLength(); i++) {
                            if (firstArray.get(i) <= 0) {
                                secondArray.set(i, secondArray.get(i) * 10);
                            } else {
                                secondArray.set(i, 0);
                            }
                        }
                    } else {
                        throw new IllegalArgumentException("Sequence sizes are not equal.");
                    }
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
