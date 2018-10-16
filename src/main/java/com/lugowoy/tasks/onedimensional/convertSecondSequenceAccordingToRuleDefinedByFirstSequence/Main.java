package com.lugowoy.tasks.onedimensional.convertSecondSequenceAccordingToRuleDefinedByFirstSequence;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.models.Array;

import static com.lugowoy.helper.models.Array.DEFAULT_LENGTH_ARRAY;

/** Created by Konstantin Lugowoy on 25.03.2017. */

public class Main {

    private static final int MIN_BOUND = -20;
    private static final int MAX_BOUND = 20;

    private static final Converting<Integer> CONVERTING = Converting::convertSecondSequenceAccordingToRuleDefinedByFirstSequence;

    public static void main(String[] args) {

        Array<Integer> firstArray = Array.create(new FillingArrayRandomIntegerNumbers().fill(DEFAULT_LENGTH_ARRAY, MIN_BOUND, MAX_BOUND));
        System.out.println("A : " + firstArray);
        System.out.println();

        Array<Integer> secondArray = Array.create(new FillingArrayRandomIntegerNumbers().fill(DEFAULT_LENGTH_ARRAY, MIN_BOUND, MAX_BOUND));
        System.out.println("B : " + secondArray);
        System.out.println();

        CONVERTING.convert(firstArray, secondArray);

        System.out.println("Result second sequence after converting : " + secondArray);

    }

}
