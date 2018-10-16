package com.lugowoy.tasks.onedimensional.replaceWithZerosElementsThatAreModuloGreaterThanTheMaximumElement;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthArray;

import java.util.Arrays;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.DEFAULT_INTEGER_NEGATIVE_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.DEFAULT_INTEGER_POSITIVE_BOUND;

/** Created by Konstantin Lugowoy on 11.03.2017. */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> array = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                                       DEFAULT_INTEGER_POSITIVE_BOUND));

        System.out.println("Original sequence : " + array);
        System.out.println();

        int maximumNumberElement = 0;

        if (Arrays.stream(array.toArray(new Integer[array.getLength()])).max(Integer::compareTo).isPresent()) {
            maximumNumberElement = Arrays.stream(array.toArray(new Integer[array.getLength()])).max(Integer::compareTo).get();
        }

        System.out.println("Result sequence : ");
        int finalMaximumNumberElement = maximumNumberElement;
        Arrays.stream(array.toArray(new Integer[array.getLength()])).forEachOrdered(integer -> {
            if (finalMaximumNumberElement != 0) {
                if (Math.abs(integer) > finalMaximumNumberElement) {
                    integer = 0;
                }
            }
            System.out.print(integer + " ");
        });

    }

}
