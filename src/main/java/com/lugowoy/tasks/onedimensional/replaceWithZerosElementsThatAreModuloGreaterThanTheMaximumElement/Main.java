package com.lugowoy.tasks.onedimensional.replaceWithZerosElementsThatAreModuloGreaterThanTheMaximumElement;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

import java.util.Arrays;

import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY;
import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY;

/** Created by Konstantin Lugowoy on 11.03.2017. */

public class Main {

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray, DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY, DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY));

        System.out.println("Original sequence : ");
        Arrays.stream(array.getArray()).forEachOrdered(integer -> System.out.print(integer + " "));
        System.out.println();

        int maximumNumberElement = 0;

        if (Arrays.stream(array.getArray()).max(Integer::compareTo).isPresent()) {
            maximumNumberElement = Arrays.stream(array.getArray()).max(Integer::compareTo).get();
        }

        System.out.println("Result sequence : ");
        int finalMaximumNumberElement = maximumNumberElement;
        Arrays.stream(array.getArray()).forEachOrdered(integer -> {
            if (finalMaximumNumberElement != 0) {
                if (Math.abs(integer) > finalMaximumNumberElement) {
                    integer = 0;
                }
            }
            System.out.print(integer + " ");
        });

    }

}
