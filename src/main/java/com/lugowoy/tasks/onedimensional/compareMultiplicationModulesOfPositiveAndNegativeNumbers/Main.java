package com.lugowoy.tasks.onedimensional.compareMultiplicationModulesOfPositiveAndNegativeNumbers;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthArray;
import com.lugowoy.tasks.onedimensional.compareMultiplicationModulesOfPositiveAndNegativeNumbers.multiplicate.Multiplication;
import com.lugowoy.tasks.onedimensional.compareMultiplicationModulesOfPositiveAndNegativeNumbers.multiplicate.MultiplicationNegativeNumbers;
import com.lugowoy.tasks.onedimensional.compareMultiplicationModulesOfPositiveAndNegativeNumbers.multiplicate.MultiplicationPositiveNumbers;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.NEGATIVE_INTEGER_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;

/** Created by Konstantin Lugowoy on 11.03.2017. */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> array = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, NEGATIVE_INTEGER_BOUND,
                                                                                                       POSITIVE_INTEGER_BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        Multiplication<Array<Integer>> multiplication = MultiplicationNegativeNumbers::multiplication;
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
