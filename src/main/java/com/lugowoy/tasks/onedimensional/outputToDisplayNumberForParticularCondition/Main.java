package com.lugowoy.tasks.onedimensional.outputToDisplayNumberForParticularCondition;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.other.LengthArray;

import java.util.Arrays;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.NEGATIVE_INTEGER_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;

/**Created by Konstantin Lugowoy on 14-Feb-17.*/

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Numbers numbers = new Numbers(Arrays.stream(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, NEGATIVE_INTEGER_BOUND,
                                                                                                               POSITIVE_INTEGER_BOUND))
                                            .mapToInt(Integer::intValue)
                                            .toArray());

        System.out.println("Original array : ");
        Arrays.stream(numbers.getNumbers()).forEachOrdered(value -> System.out.print(value + " "));

        System.out.println();

        System.out.println("Result : ");
        DISPLAY.show(numbers);

    }

    private static final Display DISPLAY = numbers -> {
        int firstValue = numbers.getNumbers()[0];
        for (int i = 0; i < numbers.getNumbers().length; i++) {
            if (firstValue <= numbers.getNumbers()[i]) {
                System.out.print(numbers.getNumbers()[i] + " ");
            }
        }
    };

}
