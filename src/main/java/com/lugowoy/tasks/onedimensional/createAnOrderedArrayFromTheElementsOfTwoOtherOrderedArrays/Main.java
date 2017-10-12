package com.lugowoy.tasks.onedimensional.createAnOrderedArrayFromTheElementsOfTwoOtherOrderedArrays;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 30.05.2017. */

public class Main {

    private static final int MIN_BOUND = -10;
    private static final int MAX_BOUND = 10;

    public static void main(String[] args) {

        int sizeArrays = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> firstArray = new CreatorOfArrayModels<>(
                                        new FactoryOfIntegerArrayModels()).create(
                                                new FillingArrayIntegerRandomNumbers().fill(sizeArrays, MIN_BOUND, MAX_BOUND));

        Arrays.sort(firstArray.getArray());

        Array<Integer> secondArray = new CreatorOfArrayModels<>(
                                         new FactoryOfIntegerArrayModels()).create(
                                                 new FillingArrayIntegerRandomNumbers().fill(sizeArrays, MIN_BOUND, MAX_BOUND));

        Arrays.sort(secondArray.getArray());

        System.out.println("Original first array : " + firstArray);
        System.out.println();

        System.out.println("Original second array : " + secondArray);
        System.out.println();

        Mergeable<Array> mergeable = Mergeable::mergeArrays;
        Array resultArray = mergeable.merge(firstArray, secondArray);

        System.out.println("Result array : " + resultArray);
        System.out.println();

    }

}
