package com.lugowoy.tasks.onedimensional.determineGreatestCommonDivisorForArrayOfNumbers;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthArray;

/** Created by Konstantin Lugowoy on 09.05.2018. */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> array = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray));

        System.out.println("Array : " + array);

        print(DeterminantGreatestCommonDivisor::determineGreatestCommonDivisor, array);

    }

    private static void print(DeterminantGreatestCommonDivisor determinantGCD, Array<Integer> array) {
        System.out.println("The greatest common divisor of the array is : " + determinantGCD.determine(array) + " .");
    }

}
