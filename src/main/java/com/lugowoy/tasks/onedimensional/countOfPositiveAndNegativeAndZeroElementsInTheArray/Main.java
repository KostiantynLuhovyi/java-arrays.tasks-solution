package com.lugowoy.tasks.onedimensional.countOfPositiveAndNegativeAndZeroElementsInTheArray;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

import java.util.Arrays;

import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY;
import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY;

/**Created by Konstantin Lugowoy on 13-Feb-17.*/

public class Main {

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray, DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY, DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY));

        System.out.println("Numbers : ");
        Arrays.stream(array.getArray()).forEachOrdered(value -> System.out.print(value + " "));

        System.out.println();

        Counting<Integer> counting = Counting::countNegativeNumber;
        System.out.println("Negative number : " + counting.count(array));

        counting = Counting::countZero;
        System.out.println("Zero : " + counting.count(array));

        counting = Counting::countPositiveNumber;
        System.out.println("Positive number : " + counting.count(array));
    }

}
