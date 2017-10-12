package com.lugowoy.tasks.onedimensional.calculateTheSumOfArrayElementsLocatedBetweenTheMinAndMaxElementsInclusive;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY;
import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY;

/** Created by Konstantin Lugowoy on 27.03.2017. */

public class Main {

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray, DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY, DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY));

        System.out.println("Original array : " + array);
        System.out.println();

        Determinable determinable = Determinable::determineMinElementIndex;
        int indexMinElement = determinable.determine(array);
        System.out.println("Index min element in the array is : " + indexMinElement);

        determinable = Determinable::determineMaxElementIndex;
        int indexMaxElement = determinable.determine(array);
        System.out.println("Index max element in the array is : " + indexMaxElement);

        System.out.println();

        Calculable calculable = Calculable::calculateTheSumOfArrayElementsLocatedBetweenTheMinAndMaxElementsInclusive;
        int sumElements = calculable.calculate(array, indexMinElement, indexMaxElement);

        if (sumElements > 0) {
            System.out.println("Sum of array elements located between the min and max elements inclusive is : " + sumElements);
        }

    }

}
