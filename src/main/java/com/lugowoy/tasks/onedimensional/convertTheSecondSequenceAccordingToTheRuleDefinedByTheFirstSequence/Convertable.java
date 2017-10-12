package com.lugowoy.tasks.onedimensional.convertTheSecondSequenceAccordingToTheRuleDefinedByTheFirstSequence;

import com.lugowoy.helper.models.arrays.Array;

/** Created by Konstantin Lugowoy on 25.03.2017. */

@FunctionalInterface
public interface Convertable<T> {

    void convert(Array<T> firstArray, Array<T> secondArray);
    
    static void convertSecondSequenceAccordingToTheRuleDefinedByTheFirstSequence(Array<Integer> firstArray, Array<Integer> secondArray) {
        if (firstArray.getArray().length == secondArray.getArray().length) {
            for (int i = 0; i < firstArray.getArray().length; i++) {
                if (firstArray.getArray()[i] <= 0) {
                    secondArray.getArray()[i] *= 10;
                } else {
                    secondArray.getArray()[i] = 0;
                }
            }
        } else {
            System.out.println("Sequence sizes are not equal.");
            System.exit(0);
        }
    }

}
