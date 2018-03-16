package com.lugowoy.tasks.onedimensional.createOrderedArrayFromElementsOfTwoOtherOrderedArrays;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

import java.util.Arrays;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_NEGATIVE_BOUND;
import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_POSITIVE_BOUND;

/** Created by Konstantin Lugowoy on 30.05.2017. */

public class Main {

    private static final FactoryArray<Integer> FACTORY = FactoryArray.getFactoryArray(new CreatorArrayNumbers<>());

    private static final int MIN_BOUND = -10;
    private static final int MAX_BOUND = 10;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<Integer> firstArray = FACTORY.create(new FillingArrayRandomIntegerNumbers().fill(lengthArray,
                                                                                               DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                               DEFAULT_INTEGER_POSITIVE_BOUND));
        Arrays.sort(firstArray.getArray());

        Array<Integer> secondArray = FACTORY.create(new FillingArrayRandomIntegerNumbers().fill(lengthArray,
                                                                                                DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                                DEFAULT_INTEGER_POSITIVE_BOUND));
        Arrays.sort(secondArray.getArray());

        System.out.println("Original first array : " + firstArray);
        System.out.println();

        System.out.println("Original second array : " + secondArray);
        System.out.println();

        Merging<Array> merging = Merging::mergeArrays;
        Array resultArray = merging.merge(firstArray, secondArray);

        System.out.println("Result array : " + resultArray);
        System.out.println();

    }

}
