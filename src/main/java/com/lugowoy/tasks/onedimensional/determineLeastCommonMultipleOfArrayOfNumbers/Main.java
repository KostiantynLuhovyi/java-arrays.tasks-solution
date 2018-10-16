package com.lugowoy.tasks.onedimensional.determineLeastCommonMultipleOfArrayOfNumbers;

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

        System.out.println("Array " + array);

        printValueOfLeastCommonMultiple(DeterminantLeastCommonMultiple::determineLeastCommonMultiple, array);

    }

    private static void printValueOfLeastCommonMultiple(DeterminantLeastCommonMultiple determinantLCM, Array<Integer> array) {
        System.out.println("The least common multiple of the array is : " + determinantLCM.determine(array) + " .");
    }

}
