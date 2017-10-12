package com.lugowoy.tasks.onedimensional.interchangeTheElementsStandingOnOddAndEvenPositionsInTheArray;

import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;

import java.util.Arrays;

import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY;
import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY;

/** Created by Konstantin Lugowoy on 22-Feb-17. */

public class Main {

    public static void main(String[] args) {

        Numbers numbers = new Numbers();
        numbers.setNumbers(Arrays.stream(new FillingArrayIntegerRandomNumbers().fill(20, DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY, DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY))
                                 .mapToInt(Integer::intValue)
                                 .toArray());

        System.out.println("Original array : ");
        Arrays.stream(numbers.getNumbers()).forEachOrdered(value -> System.out.print(value + " "));
        System.out.println();

        INTERCHANGEABLE.interchange(numbers);

        System.out.println("Array after exchange of places of elements of even and odd positions : ");
        Arrays.stream(numbers.getNumbers()).forEachOrdered(value -> System.out.print(value + " "));
        
    }

    private static final Interchangeable INTERCHANGEABLE = numbers -> {
        for (int i = 1; i < numbers.getNumbers().length; i++) {
            if (i % 2 == 0) {
                int tmp = numbers.getNumbers()[i];
                numbers.getNumbers()[i] = numbers.getNumbers()[i + 1];
                numbers.getNumbers()[i + 1] = tmp;
            }
        }
    };
}
