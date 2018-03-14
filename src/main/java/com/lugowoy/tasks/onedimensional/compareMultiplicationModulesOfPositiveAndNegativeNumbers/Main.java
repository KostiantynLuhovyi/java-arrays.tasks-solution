package com.lugowoy.tasks.onedimensional.compareMultiplicationModulesOfPositiveAndNegativeNumbers;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;
import com.lugowoy.tasks.onedimensional.compareMultiplicationModulesOfPositiveAndNegativeNumbers.multiplicate.Multiplication;
import com.lugowoy.tasks.onedimensional.compareMultiplicationModulesOfPositiveAndNegativeNumbers.multiplicate.MultiplicationNegativeNumbers;
import com.lugowoy.tasks.onedimensional.compareMultiplicationModulesOfPositiveAndNegativeNumbers.multiplicate.MultiplicationPositiveNumbers;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_NEGATIVE_BOUND;
import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_POSITIVE_BOUND;

/** Created by Konstantin Lugowoy on 11.03.2017. */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<Integer> array = FactoryArray.getFactoryArray(new CreatorArrayNumbers<Integer>()).create(
                                                                new FillingArrayRandomIntegerNumbers().fill(lengthArray,
                                                                                                            DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                                            DEFAULT_INTEGER_POSITIVE_BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        Multiplication<Integer, Array<Integer>> multiplication = MultiplicationNegativeNumbers::multiplication;
        int resultModuleOfNegativeNumbers = Math.abs(multiplication.multiply(array));

        multiplication = MultiplicationPositiveNumbers::multiplication;
        int resultModuleOfPositiveNumbers = Math.abs(multiplication.multiply(array));

        if (resultModuleOfNegativeNumbers > resultModuleOfPositiveNumbers) {
            System.out.println("Multiplication negative numbers on the module larger positive numbers.");
        } else if (resultModuleOfPositiveNumbers > resultModuleOfNegativeNumbers) {
            System.out.println("Multiplication positive numbers on the module larger negative numbers.");
        }

    }

}
