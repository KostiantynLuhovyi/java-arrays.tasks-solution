package com.lugowoy.tasks.onedimensional.interchangeElementsStandingOnOddAndEvenPositionsInArray;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;

import java.util.Arrays;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.NEGATIVE_INTEGER_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;

/** Created by Konstantin Lugowoy on 22-Feb-17. */

public class Main {

    private static final int LENGTH_ARRAY = 20;

    public static void main(String[] args) {

        Numbers numbers = new Numbers();
        numbers.setNumbers(Arrays.stream(new FillingArrayRandomIntegerNumbers().fill(LENGTH_ARRAY, NEGATIVE_INTEGER_BOUND,
                                                                                                   POSITIVE_INTEGER_BOUND))
                                 .mapToInt(Integer::intValue)
                                 .toArray());

        System.out.println("Original array : ");
        Arrays.stream(numbers.getNumbers()).forEachOrdered(value -> System.out.print(value + " "));
        System.out.println();

        INTERCHANGING.interchange(numbers);

        System.out.println("Array after exchange of places of elements of even and odd positions : ");
        Arrays.stream(numbers.getNumbers()).forEachOrdered(value -> System.out.print(value + " "));
        
    }

    private static final Interchanging INTERCHANGING = numbers -> {
        for (int i = 1; i < numbers.getNumbers().length; i++) {
            if (i % 2 == 0) {
                int tmp = numbers.getNumbers()[i];
                numbers.getNumbers()[i] = numbers.getNumbers()[i + 1];
                numbers.getNumbers()[i + 1] = tmp;
            }
        }
    };
}
