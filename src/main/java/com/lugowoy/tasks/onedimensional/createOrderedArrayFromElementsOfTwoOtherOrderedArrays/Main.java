package com.lugowoy.tasks.onedimensional.createOrderedArrayFromElementsOfTwoOtherOrderedArrays;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthArray;

import java.util.Arrays;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.NEGATIVE_INTEGER_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;

/** Created by Konstantin Lugowoy on 30.05.2017. */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> firstArray = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, NEGATIVE_INTEGER_BOUND,
                                                                                                            POSITIVE_INTEGER_BOUND));

        Arrays.sort(firstArray.toArray(new Integer[firstArray.getLength()]));

        Array<Integer> secondArray = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, NEGATIVE_INTEGER_BOUND,
                                                                                                             POSITIVE_INTEGER_BOUND));

        Arrays.sort(secondArray.toArray(new Integer[secondArray.getLength()]));

        System.out.println("Original first array : " + firstArray);
        System.out.println();

        System.out.println("Original second array : " + secondArray);
        System.out.println();

        Merging<Array> merging = Merging::mergeArrays;
        Array resultArray = merging.merge(firstArray, secondArray);

        System.out.println("Result array : " + resultArray);
        System.out.println();

    }

}
