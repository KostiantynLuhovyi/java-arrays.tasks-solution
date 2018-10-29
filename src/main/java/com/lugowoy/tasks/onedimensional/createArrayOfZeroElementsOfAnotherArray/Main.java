package com.lugowoy.tasks.onedimensional.createArrayOfZeroElementsOfAnotherArray;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;
import com.lugowoy.helper.other.LengthArray;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.NEGATIVE_INTEGER_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;

/**Created by Konstantin Lugowoy on 12-Feb-17.*/

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> originalIntegerArray = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, NEGATIVE_INTEGER_BOUND,
                                                                                                                      POSITIVE_INTEGER_BOUND));

        System.out.println("Elements of of the original array : " + originalIntegerArray);
        System.out.println();

        Array<Integer> integerArrayIndexZero = FILLING.fillArray(originalIntegerArray);

        System.out.print("Index of zero elements of the original array : ");
        if (integerArrayIndexZero.getLength() != 0) {
            for (int i = 0; i < integerArrayIndexZero.getLength(); i++) {
                System.out.print(integerArrayIndexZero.get(i) + " ");
            }
        } else {
            System.out.println("It does not contain zero elements.");
        }

    }

    private static final Filling FILLING = originalArray -> {
        Array<Integer> tmpArray = Array.create(0);
        if (CheckerArray.checkArrayNonNull(originalArray)) {
            if (CheckerArray.checkLengthOfArrayIsGreaterZero(originalArray.getLength())) {
                for (int i = 0; i < originalArray.getLength(); i++) {
                    if (originalArray.get(i) == 0) {
                        tmpArray.add(i);
                    }
                }
            }
        }
        return tmpArray;
    };

}
