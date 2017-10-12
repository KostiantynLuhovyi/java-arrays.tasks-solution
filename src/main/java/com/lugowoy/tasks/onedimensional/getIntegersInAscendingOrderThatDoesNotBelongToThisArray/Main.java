package com.lugowoy.tasks.onedimensional.getIntegersInAscendingOrderThatDoesNotBelongToThisArray;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 11.04.2017. */

public class Main {

    private static final int MIN_BOUND = -50;
    private static final int MAX_BOUND = 50;

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray, MIN_BOUND, MAX_BOUND));

        System.out.println("Original array : ");
        Arrays.stream(array.getArray()).forEachOrdered(integer -> System.out.print(integer + " "));
        System.out.println();

        Findable<Integer, Array> findable = Findable::findMaxNumber;
        int maxNumberInTheArray = findable.find(array);
        System.out.println("Max number in the array : " + maxNumberInTheArray);

        findable = Findable::findMinNumber;
        int minNumberInTheArray = findable.find(array);
        System.out.println("Min number in the array : " + minNumberInTheArray);

        Array<Integer> arraySorted = new CreatorOfArrayModels<>(new FactoryOfIntegerArrayModels()).create(array.getArray());
        Arrays.sort(arraySorted.getArray());

        for (int j = minNumberInTheArray + 1; j < maxNumberInTheArray; j++) {
            if (!(Arrays.binarySearch(array.getArray(), j) > 0)) {
                System.out.print(j + " ");
            }
        }

    }

}
