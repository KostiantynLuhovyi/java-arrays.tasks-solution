package com.lugowoy.tasks.onedimensional.outputElementsIncludedInInterval;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.other.ArrayLength;

import java.util.Arrays;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_NEGATIVE_BOUND;
import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_POSITIVE_BOUND;

/** Created by Konstantin Lugowoy on 06.03.2017. */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Integer[] integers = new FillingArrayRandomIntegerNumbers().fill(lengthArray, DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                      DEFAULT_INTEGER_POSITIVE_BOUND);

        System.out.println("Original sequence : ");
        Arrays.stream(integers).forEachOrdered(integer -> System.out.print(integer + " "));
        System.out.println();

        System.out.println("Enter the value of the start of the segment : ");
        int startOfInterval = READER.readInt();
        System.out.println("Enter the value of the finish of the segment : ");
        int finishOfInterval = READER.readInt();

        System.out.println("Elements entering the sequence of numbers from a segment : ");
        Arrays.stream(integers).forEachOrdered(integer -> {
            if ((integer > startOfInterval) && (integer < finishOfInterval)) {
                System.out.print(integer + " ");
            }
        });

    }

}
