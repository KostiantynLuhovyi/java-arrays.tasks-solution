package com.lugowoy.tasks.onedimensional.createNewArrayFromUniqueElementsOfOriginalArray;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthArray;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.NEGATIVE_INTEGER_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;

/** Created by Konstantin Lugowoy on 29.05.2017. */

public class Main {

    private static final DeterminantUniqueness DETERMINANT = DeterminantUniqueness::determineTheUniqueElementsOfTheOriginalArray;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> array = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, NEGATIVE_INTEGER_BOUND,
                                                                                                       POSITIVE_INTEGER_BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        Array<Integer> newArrayFromTheUniqueElements = DETERMINANT.determineUniqueness(array);

        System.out.println("New array from the unique elements : " + newArrayFromTheUniqueElements);
        System.out.println();

    }

}
