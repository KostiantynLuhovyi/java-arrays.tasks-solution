package com.lugowoy.tasks.onedimensional.outputElementsOfIndexesWhichAreDegreeOfTwo;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.other.ArrayLength;

import java.util.Arrays;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_NEGATIVE_BOUND;
import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_POSITIVE_BOUND;

/** Created by Konstantin Lugowoy on 01.03.2017. */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Integer[] integersArray = new FillingArrayRandomIntegerNumbers().fill(lengthArray, DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                           DEFAULT_INTEGER_POSITIVE_BOUND);

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
