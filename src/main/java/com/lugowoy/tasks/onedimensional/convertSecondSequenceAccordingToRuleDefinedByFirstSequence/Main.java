package com.lugowoy.tasks.onedimensional.convertSecondSequenceAccordingToRuleDefinedByFirstSequence;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

import java.util.Arrays;

import static com.lugowoy.helper.models.arrays.Array.*;

/** Created by Konstantin Lugowoy on 25.03.2017. */

public class Main {

    private static final FactoryArray<Integer> FACTORY = FactoryArray.getFactoryArray(new CreatorArrayNumbers<Integer>());

    private static final int MIN_BOUND = -20;
    private static final int MAX_BOUND = 20;

    private static final Converting<Integer> CONVERTING = Converting::convertSecondSequenceAccordingToRuleDefinedByFirstSequence;

    public static void main(String[] args) {

        Array<Integer> firstArray = FACTORY.create(new FillingArrayRandomIntegerNumbers().fill(DEFAULT_LENGTH_ARRAY,
                                                                                               MIN_BOUND,
                                                                                               MAX_BOUND));
        System.out.println("A : ");
        showArray(firstArray);
        System.out.println();

        Array<Integer> secondArray = FACTORY.create(new FillingArrayRandomIntegerNumbers().fill(DEFAULT_LENGTH_ARRAY,
                                                                                                MIN_BOUND,
                                                                                                MAX_BOUND));
        System.out.println("B : ");
        showArray(secondArray);
        System.out.println();

        CONVERTING.convert(firstArray, secondArray);

        System.out.println("Result second sequence after converting : ");
        Arrays.stream(secondArray.getArray()).forEachOrdered(integer -> System.out.print(integer + " "));
        System.out.println();

    }

    private static void showArray(Array<Integer> array) {
        Arrays.stream(array.getArray()).forEachOrdered(integer -> System.out.print(integer + " "));
        System.out.println();
    }

}
