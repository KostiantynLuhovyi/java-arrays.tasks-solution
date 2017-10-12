package com.lugowoy.tasks.onedimensional.determineTheMostRepeatedElementInAnArray;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

import java.util.Objects;

/** Created by Konstantin Lugowoy on 22.03.2017. */

public class Main {

    private static final int BOUND = 50;

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray, BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        determineTheMostRepeatedElementsInAnArray.determine(array);

    }

    private static Determinable<Integer> determineTheMostRepeatedElementsInAnArray = array -> {
        int count, countMax = 0, value = 1, num = 0;

        if (Objects.nonNull(array)) {
            if ((Objects.nonNull(array.getArray())) && (array.getArray().length > 2)) {
                for (int i = 0; i < array.getArray().length; i++) {
                    count = 1;
                    for (int j = i + 1; j < array.getArray().length; j++) {
                        if (array.getArray()[i].equals(array.getArray()[j])) {
                            value = array.getArray()[j];
                            count++;
                        } else if (count > countMax) {
                            countMax = count;
                            if (value <= array.getArray()[i]) {
                                num = i;
                            }
                        }
                    }
                }
            }
        }
        if (countMax == 1) {
            System.out.println("No repetitive elements in the array.");
        } else {
            System.out.println("Element " + array.getArray()[num] + ", repeated " + countMax);
        }
    };

}
