package com.lugowoy.tasks.onedimensional.determineSequenceOfNumbersIsIncreasing;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthArray;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.NEGATIVE_INTEGER_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;

/**Created by Konstantin Lugowoy on 13-Feb-17.*/

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> array = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, NEGATIVE_INTEGER_BOUND,
                                                                                                       POSITIVE_INTEGER_BOUND));

        System.out.println("Sequence : " + array);

        boolean resultIncreasingSequence = false;
        if (array.get(1) > array.get(0)) {
            resultIncreasingSequence = true;
        }

        System.out.println();

        if (resultIncreasingSequence) {
            System.out.println("The sequence of increasing.");
        } else {
            System.out.println("The sequence of a not increasing");
        }

    }

}
