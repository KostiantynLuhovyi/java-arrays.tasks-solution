package com.lugowoy.tasks.onedimensional.replaceSmallestNumberInSequenceByArithmeticMeanOfNumbers;

/** Created by Konstantin Lugowoy on 25.03.2017. */

@FunctionalInterface
public interface Replacement<T> {

    void replace(Sequence<T> sequence, T numberForReplace);

    static void replaceTheSmallestNumberInTheSequence(Sequence<Integer> sequence, Integer numberForReplace) {
        int indexOfValueForReplace = 0, valueForReplace = Integer.MAX_VALUE;

        for (int i = 0; i < sequence.getSequence().length; i++) {
            if (sequence.getSequence()[i] <= valueForReplace) {
                valueForReplace = sequence.getSequence()[i];
                indexOfValueForReplace = i;
            }
        }
        sequence.getSequence()[indexOfValueForReplace] = numberForReplace;
    }

}
