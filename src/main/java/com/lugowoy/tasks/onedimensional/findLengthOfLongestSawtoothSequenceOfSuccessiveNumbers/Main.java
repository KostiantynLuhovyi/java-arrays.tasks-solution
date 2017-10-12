package com.lugowoy.tasks.onedimensional.findLengthOfLongestSawtoothSequenceOfSuccessiveNumbers;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

/** Created by Konstantin Lugowoy on 27.06.2017. */

public class Main {

    private static final int BOUND = 100;

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray, BOUND));

        System.out.println("Original " + array);

        System.out.printf("The length of the longest sawtooth sequence is %d .", getLengthSawOfArrayElements(array));

    }

    private static int getLengthSawOfArrayElements(Array<Integer> array) {
        int lengthSaw = 0, maxLengthSaw = 0;
        boolean isPrev = false;

        for (int i = 1; i < array.getArray().length - 1; i++) {
            if ((array.getArray()[i - 1] < array.getArray()[i])
                    && (array.getArray()[i] > array.getArray()[i + 1])) {
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
        return Math.max(maxLengthSaw, lengthSaw);
    }

}
