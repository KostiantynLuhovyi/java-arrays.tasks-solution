package com.lugowoy.tasks.onedimensional.outputElementsOfIndexesWhichAreDegreeOfTwo;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.other.LengthArray;

import java.util.Arrays;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.NEGATIVE_INTEGER_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;

/** Created by Konstantin Lugowoy on 01.03.2017. */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Integer[] integersArray = new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, NEGATIVE_INTEGER_BOUND,
                                                                                             POSITIVE_INTEGER_BOUND);

        System.out.println("Original : ");
        Arrays.stream(integersArray).forEachOrdered(integer -> System.out.print(integer + " "));
        System.out.println();

        System.out.println("Result : ");
        output(integersArray);

    }

    private static void output(Integer[] integers) {
        for (int i = 0; i < integers.length; i++) {
            if (i > 1 && i % 2 == 0) System.out.println("Index : " + i + " = " + "value : " + integers[i]);
        }
    }

}
