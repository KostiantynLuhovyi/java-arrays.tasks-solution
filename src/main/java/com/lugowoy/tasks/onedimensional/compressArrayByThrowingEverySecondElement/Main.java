package com.lugowoy.tasks.onedimensional.compressArrayByThrowingEverySecondElement;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayChecker;
import com.lugowoy.helper.other.ArrayLength;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_NEGATIVE_BOUND;
import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_POSITIVE_BOUND;
import static com.lugowoy.helper.other.ArrayChecker.checkArrayNonNull;

/** Created by Konstantin Lugowoy on 13.03.2017. */

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

        System.out.println("Result array : " + array);
        System.out.println();

    }

    private static final Compressing<Array<Integer>> COMPRESSING = array -> {
        try {
            if (checkArrayNonNull(array)) {
                if ((ArrayChecker.checkArrayNonNull(array.getArray())) && (array.getArray().length >= 2)) {
                    Array<Integer> tmpArray = FactoryArray.getFactoryArray(new CreatorArrayNumbers<Integer>()).create(0);
                    for (int i = 0; i < array.getLength(); i++) {
                        if ((i % 2 == 0) || (i == 0)) {
                            tmpArray.add(array.get(i));
                        }
                    }
                    array.setArray(tmpArray.getArray());
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    };

}
