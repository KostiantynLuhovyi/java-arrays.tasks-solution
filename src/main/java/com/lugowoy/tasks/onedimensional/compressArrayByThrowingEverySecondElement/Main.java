package com.lugowoy.tasks.onedimensional.compressArrayByThrowingEverySecondElement;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;
import com.lugowoy.helper.other.LengthArray;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.NEGATIVE_INTEGER_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;

/** Created by Konstantin Lugowoy on 13.03.2017. */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> array = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, NEGATIVE_INTEGER_BOUND,
                                                                                                       POSITIVE_INTEGER_BOUND));

        System.out.println("Original array : " + array);

        COMPRESSING.compress(array);

        System.out.println("Result of compress array : " + array);

    }

    private static final Compressing<Array<Integer>> COMPRESSING = array -> {
        if (CheckerArray.checkArrayNonNull(array)) {
            if (array.getLength() >= 2) {
                Array<Integer> tmpArray = Array.create(0);
                for (int i = 0; i < array.getLength(); i++) {
                    if ((i % 2 == 0) || (i == 0)) {
                        tmpArray.add(array.get(i));
                    }
                }
                array.setArray(tmpArray.toArray(new Integer[tmpArray.getLength()]));
            }
        }
    };

}
