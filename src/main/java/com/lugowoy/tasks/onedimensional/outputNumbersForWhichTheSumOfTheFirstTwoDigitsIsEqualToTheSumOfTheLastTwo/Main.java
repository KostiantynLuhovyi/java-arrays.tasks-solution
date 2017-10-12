package com.lugowoy.tasks.onedimensional.outputNumbersForWhichTheSumOfTheFirstTwoDigitsIsEqualToTheSumOfTheLastTwo;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 29.05.2017. */

public class Main {

    private static final int MIN_BOUND = 1000;
    private static final int MAX_BOUND = 10000;

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray, MIN_BOUND, MAX_BOUND));

        System.out.println("Original array : ");
        Arrays.stream(array.getArray()).forEachOrdered(value -> System.out.print(value + " "));
        System.out.println();

        System.out.println("Result numbers for which the sum of the first two digits is equal to the sum of the last two : ");
        Determinable determinable = Determinable::determineNumbersForWhichTheSumOfTheFirstTwoDigitsIsEqualToTheSumOfTheLastTwo;
        Arrays.stream(array.getArray()).forEachOrdered(value -> {
            if (determinable.determine(value)) {
                System.out.print(value + " ");
            }
        });

    }

}
