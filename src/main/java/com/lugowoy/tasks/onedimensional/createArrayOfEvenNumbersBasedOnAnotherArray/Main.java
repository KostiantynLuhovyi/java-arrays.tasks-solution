package com.lugowoy.tasks.onedimensional.createArrayOfEvenNumbersBasedOnAnotherArray;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;
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

        System.out.println("Original array numbers : " + array);

        Array<Integer> evenNumbersArray = getArrayWithEvenNumbers(array);

        System.out.println("Even numbers of original array : " + evenNumbersArray);

    }

    private static Array<Integer> getArrayWithEvenNumbers(Array<Integer> array) {
        Array<Integer> resultArray = Array.create(0);
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsGreaterZero(array.getLength())) {
                for (int i = 0; i < array.getLength(); i++) {
                    if (array.get(i) % 2 == 0) {
                        resultArray.add(array.get(i));
                    }
                }
            }
        }
        return resultArray;
    }

}
