package com.lugowoy.tasks.onedimensional.outputToDisplayTheNumberForParticularCondition;

import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

import java.util.Arrays;

import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY;
import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY;

/**Created by Konstantin Lugowoy on 14-Feb-17.*/

public class Main {

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Numbers numbers = new Numbers(Arrays.stream(new FillingArrayIntegerRandomNumbers().fill(sizeArray, DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY, DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY))
                                            .mapToInt(Integer::intValue)
                                            .toArray());

        System.out.println("Original array : ");
        Arrays.stream(numbers.getNumbers()).forEachOrdered(value -> System.out.print(value + " "));

        System.out.println();

        System.out.println("Result : ");
        DISPLAYABLE.displaying(numbers);

    }

    private static final Displayable DISPLAYABLE = numbers -> {
        int firstValue = numbers.getNumbers()[0];
        for (int i = 0; i < numbers.getNumbers().length; i++) {
            if (firstValue <= numbers.getNumbers()[i]) {
                System.out.print(numbers.getNumbers()[i] + " ");
            }
        }
    };

}
