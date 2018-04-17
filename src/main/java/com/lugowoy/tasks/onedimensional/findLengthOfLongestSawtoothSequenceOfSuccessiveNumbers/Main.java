package com.lugowoy.tasks.onedimensional.findLengthOfLongestSawtoothSequenceOfSuccessiveNumbers;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

import static com.lugowoy.helper.other.ArrayChecker.checkArrayNonNull;
import static com.lugowoy.helper.other.ArrayChecker.checkLengthOfArrayIsGreaterZero;

/** Created by Konstantin Lugowoy on 27.06.2017. */

public class Main {

    private static final int BOUND = 100;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<Integer> array = FactoryArray.getFactoryArray(new CreatorArrayNumbers<Integer>()).create(
                                                                new FillingArrayRandomIntegerNumbers().fill(lengthArray,
                                                                                                            BOUND));

        System.out.println("Original " + array);

        System.out.printf("The length of the longest sawtooth sequence is %d .", getLengthSawOfArrayElements(array));

    }

    private static int getLengthSawOfArrayElements(Array<Integer> array) {
        int lengthSaw = 0, maxLengthSaw = 0;
        boolean isPrev = false;
        try {
            if (checkArrayNonNull(array)) {
                if (checkLengthOfArrayIsGreaterZero(array.getLength())) {
                    for (int i = 1; i < array.getLength() - 1; i++) {
                        if ((array.get(i - 1) < array.get(i))
                                && (array.get(i) > array.get(i + 1))) {
                            if (isPrev) {
                                lengthSaw += 2;
                            } else {
                                lengthSaw = 3;
                                isPrev = true;
                            }
                            i++;
                        } else {
                            isPrev = false;
                            maxLengthSaw = Math.max(maxLengthSaw, lengthSaw);
                        }
                    }
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        return Math.max(maxLengthSaw, lengthSaw);
    }

}
