package com.lugowoy.tasks.onedimensional.determineTheNumberOfDifferentElementsInOneDimensionalArray;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

/** Created by Konstantin Lugowoy on 28.05.2017. */

public class Main {

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray));

        System.out.println("Original array : " + array);
        System.out.println();

        Determinable<Integer> determinable = Determinable::determineTheNumberOfDifferentElementsInOneDimensionalArray;
        int numberOfDifferentElements = determinable.determine(array);

        System.out.printf("In a one-dimensional array of %d different elements", numberOfDifferentElements);

    }

}
