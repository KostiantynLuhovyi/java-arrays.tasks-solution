package com.lugowoy.tasks.onedimensional.outputElementsIncludedInTheInterval;

import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingDataUserInputInConsole;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

import java.util.Arrays;

import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY;
import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY;

/** Created by Konstantin Lugowoy on 06.03.2017. */

public class Main {

    private static Reader reader = new Reader(new ReadingDataUserInputInConsole());

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Integer[] integers = new FillingArrayIntegerRandomNumbers().fill(sizeArray, DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY, DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY);

        System.out.println("Original sequence : ");
        Arrays.stream(integers).forEachOrdered(integer -> System.out.print(integer + " "));
        System.out.println();

        System.out.println("Enter the value of the start of the segment : ");
        int startOfInterval = reader.readInt();
        System.out.println("Enter the value of the finish of the segment : ");
        int finishOfInterval = reader.readInt();

        System.out.println("Elements entering the sequence of numbers from a segment : ");
        Arrays.stream(integers).forEachOrdered(integer -> {
            if ((integer > startOfInterval) && (integer < finishOfInterval)) {
                System.out.print(integer + " ");
            }
        });

    }

}
