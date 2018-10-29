package com.lugowoy.tasks.onedimensional.countOfPositiveAndNegativeAndZeroElementsInArray;

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

        System.out.println("Numbers : " + array);

        System.out.println();

        Counting<Integer> counting = Counting::countNegativeNumber;
        System.out.println("Negative number : " + counting.count(array));

        counting = Counting::countZero;
        System.out.println("Zero : " + counting.count(array));

        counting = Counting::countPositiveNumber;
        System.out.println("Positive number : " + counting.count(array));
    }

}
