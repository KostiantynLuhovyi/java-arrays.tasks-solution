package com.lugowoy.tasks.onedimensional.convertTheSecondSequenceAccordingToTheRuleDefinedByTheFirstSequence;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 25.03.2017. */

public class Main {

    private static final int MIN_BOUND = -20;
    private static final int MAX_BOUND = 20;

    private static final Convertable<Integer> CONVERTABLE = Convertable::convertSecondSequenceAccordingToTheRuleDefinedByTheFirstSequence;

    public static void main(String[] args) {

        Array<Integer> firstArray = getIntegerArray();
        System.out.println("A : ");
        showArray(firstArray);
        System.out.println();

        Array<Integer> secondArray = getIntegerArray();
        System.out.println("B : ");
        showArray(secondArray);
        System.out.println();

        CONVERTABLE.convert(firstArray, secondArray);

        System.out.println("Result second sequence after converting : ");
        Arrays.stream(secondArray.getArray()).forEachOrdered(integer -> System.out.print(integer + " "));
        System.out.println();

    }

    private static Array<Integer> getIntegerArray() {
        return new CreatorOfArrayModels<>(new FactoryOfIntegerArrayModels()).create(
                                                new FillingArrayIntegerRandomNumbers().fill(DeterminatorSizeOfArray.determineSizeOfArray(), MIN_BOUND, MAX_BOUND));
    }

    private static void showArray(Array<Integer> array) {
        Arrays.stream(array.getArray()).forEachOrdered(integer -> System.out.print(integer + " "));
        System.out.println();
    }

}
