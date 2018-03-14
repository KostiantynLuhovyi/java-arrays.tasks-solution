package com.lugowoy.tasks.onedimensional.compressArrayByThrowingOutNullElements;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_NEGATIVE_BOUND;
import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_POSITIVE_BOUND;
import static com.lugowoy.helper.other.ArrayChecker.checkArrayNonNull;
import static com.lugowoy.helper.other.ArrayChecker.checkLengthOfArrayIsGreaterZero;

/** Created by Konstantin Lugowoy on 16.03.2017. */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<Integer> array = FactoryArray.getFactoryArray(new CreatorArrayNumbers<Integer>()).create(
                                                                new FillingArrayRandomIntegerNumbers().fill(lengthArray,
                                                                                                            DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                                            DEFAULT_INTEGER_POSITIVE_BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        COMPRESSING.compress(array);

        System.out.println();
        System.out.println("Result array : " + array);
    }

    private static final Compressing<Integer> COMPRESSING = array -> {
        int numberZeroElements = 0;
        try {
            if (checkArrayNonNull(array)) {
                if (checkArrayNonNull(array.getArray())
                        && checkLengthOfArrayIsGreaterZero(array.getLength())) {
                    Array<Integer> tmpArray = FactoryArray.getFactoryArray(new CreatorArrayNumbers<Integer>()).create(0);
                    for (int i = 0; i < array.getLength(); i++) {
                        if (array.get(i) != 0) {
                            tmpArray.add(array.get(i));
                        } else {
                            numberZeroElements++;
                        }
                    }
                    array.setArray(tmpArray.getArray());
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.printf("Number of zero elements in the array : %d .", numberZeroElements);
        System.out.println();
    };

}
