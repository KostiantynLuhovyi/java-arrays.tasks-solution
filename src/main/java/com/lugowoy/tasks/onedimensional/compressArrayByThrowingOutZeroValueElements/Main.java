package com.lugowoy.tasks.onedimensional.compressArrayByThrowingOutZeroValueElements;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;
import com.lugowoy.helper.other.LengthArray;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.NEGATIVE_INTEGER_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;

/** Created by Konstantin Lugowoy on 16.03.2017. */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> array = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, NEGATIVE_INTEGER_BOUND,
                                                                                                       POSITIVE_INTEGER_BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        COMPRESSING.compress(array);

        System.out.println();
        System.out.println("Result array : " + array);
    }

    private static final Compressing<Integer> COMPRESSING = array -> {
        int numberZeroElements = 0;
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsGreaterZero(array.getLength())) {
                Array<Integer> tmpArray = Array.create(0);
                for (int i = 0; i < array.getLength(); i++) {
                    if (array.get(i) != 0) {
                        tmpArray.add(array.get(i));
                    } else {
                        numberZeroElements++;
                    }
                }
                array.setArray(tmpArray.toArray(new Integer[tmpArray.getLength()]));
            }
        }
        System.out.printf("Number of zero elements in the array : %d .", numberZeroElements);
        System.out.println();
    };

}
