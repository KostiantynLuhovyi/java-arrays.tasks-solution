package com.lugowoy.tasks.onedimensional.outputNumbersUpToAndIncludingZero;

import java.util.Arrays;
import java.util.Random;

/** Created by Konstantin Lugowoy on 22-Feb-17. */

public class Main {

    public static void main(String[] args) {

        Numbers numbers = new Numbers();
        numbers.setNumbers(Arrays.stream(new Integer[20])
                                 .mapToInt(value -> value = new Random()
                                 .nextInt(50))
                                 .toArray());

        System.out.println("Original array : ");
        Arrays.stream(numbers.getNumbers()).forEachOrdered(value -> System.out.print(value + " "));
        System.out.println();

        System.out.println("Result : ");
        outputNumbersUpToAndIncludingZero(numbers);

    }

    private static void outputNumbersUpToAndIncludingZero(Numbers numbers) {
        for (int i = 0; i < numbers.getNumbers().length; i++) {
            System.out.print(numbers.getNumbers()[i] + " ");
            if (numbers.getNumbers()[i] == 0) {
                break;
            }
        }
    }

}
