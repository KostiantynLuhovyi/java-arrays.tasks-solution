package com.lugowoy.tasks.onedimensional.calculateTheSumOfTheMaxAndMinElementOfThisParticularSequence;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

import java.util.Objects;

import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY;
import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY;

/** Created by Konstantin Lugowoy on 01.03.2017. */

public class Main {

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray, DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY, DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY));

        System.out.println("Original : " + array);
        System.out.println();

        Findable<Integer> findable = Main::findMax;
        int maxElement = findable.find(array.getArray());
        System.out.println("Max element in the array is " + maxElement);

        findable = Main::findMin;
        int minElement = findable.find(array.getArray());
        System.out.println("Min element in the array is " + minElement);

        System.out.println();

        System.out.println("Result summation : " + (maxElement + minElement));

    }

    private static int findMax(Integer[] array) {
        int result = 0;
        if ((Objects.nonNull(array)) && (array.length > 0)) {
            for (Integer integer : array) {
                if (integer > result) {
                    result = integer;
                }
            }
        } else {
            System.out.println("The array is not valid for any operations or calculations.");
        }
        return result;
    }

    private static int findMin(Integer[] array) {
        int result = 200;
        if ((Objects.nonNull(array)) && (array.length > 0)) {
            for (Integer integer : array) {
                if (integer < result) {
                    result = integer;
                }
            }
        } else {
            System.out.println("The array is not valid for any operations or calculations.");
        }
        return result;
    }

}
