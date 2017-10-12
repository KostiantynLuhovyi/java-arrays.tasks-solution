package com.lugowoy.tasks.onedimensional.createNewArrayFromTheUniqueElementsOfTheOriginalArray;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 29.05.2017. */

public class Main {

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                        new FactoryOfIntegerArrayModels()).create(
                                                new FillingArrayIntegerRandomNumbers().fill(sizeArray, -10, 10));

        System.out.println("Original array : ");
        Arrays.stream(array.getArray()).forEachOrdered(integer -> System.out.print(integer + " "));
        System.out.println();

        DeterminableUniqueness determinableUniqueness = DeterminableUniqueness::determineTheUniqueElementsOfTheOriginalArray;

        Array<Integer> newArrayFromTheUniqueElements = determinableUniqueness.determineUniqueness(array);

        System.out.println("New array from the unique elements : ");
        Arrays.stream(newArrayFromTheUniqueElements.getArray()).forEachOrdered(integer -> System.out.print(integer + " "));
        System.out.println();

    }

}
