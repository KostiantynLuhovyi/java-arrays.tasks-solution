package com.lugowoy.tasks.onedimensional.compareTheMultiplicationModulesOfPositiveAndNegativeNumbers;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;
import com.lugowoy.tasks.onedimensional.compareTheMultiplicationModulesOfPositiveAndNegativeNumbers.multiplicate.Multipliable;
import com.lugowoy.tasks.onedimensional.compareTheMultiplicationModulesOfPositiveAndNegativeNumbers.multiplicate.MultipliableNegativeNumbers;
import com.lugowoy.tasks.onedimensional.compareTheMultiplicationModulesOfPositiveAndNegativeNumbers.multiplicate.MultipliablePositiveNumbers;

import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY;
import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY;

/** Created by Konstantin Lugowoy on 11.03.2017. */

public class Main {

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray, DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY, DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY));

        System.out.println("Original array : " + array);
        System.out.println();

        Multipliable<Integer, Array<Integer>> multipliable = MultipliableNegativeNumbers::multiplication;
        int resultModuleOfNegativeNumbers = Math.abs(multipliable.multiplication(array));

        multipliable = MultipliablePositiveNumbers::multiplication;
        int resultModuleOfPositiveNumbers = Math.abs(multipliable.multiplication(array));

        if (resultModuleOfNegativeNumbers > resultModuleOfPositiveNumbers) {
            System.out.println("Multiplication negative numbers on the module larger positive numbers.");
        } else if (resultModuleOfPositiveNumbers > resultModuleOfNegativeNumbers) {
            System.out.println("Multiplication positive numbers on the module larger negative numbers.");
        }

    }

}
