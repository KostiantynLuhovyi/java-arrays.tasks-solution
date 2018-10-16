package com.lugowoy.tasks.onedimensional.outputNumbersForWhichSumOfFirstTwoDigitsIsEqualToSumOfLastTwo;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthArray;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 29.05.2017. */

public class Main {

    private static final int START_BOUND = 1000;
    private static final int END_BOUND = 10000;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> array = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, START_BOUND, END_BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        System.out.println("Result numbers for which the sum of the first two digits is equal to the sum of the last two : ");
        Determinant determinant = Determinant::determineNumbersForWhichTheSumOfTheFirstTwoDigitsIsEqualToTheSumOfTheLastTwo;
        Arrays.stream(array.toArray(new Integer[array.getLength()])).forEachOrdered(value -> {
            if (determinant.determine(value)) {
                System.out.print(value + " ");
            }
        });

    }

}
