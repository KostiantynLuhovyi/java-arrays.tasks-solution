package com.lugowoy.tasks.onedimensional.findTheSumOfAnArrayOfMultipleElementsToThisPresent;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingDataUserInputInConsole;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

/**Created by Konstantin Lugowoy on 12-Feb-17.*/

public class Main {

    private static final int BOUND = 50;

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray, BOUND));

        System.out.println("Result fill arrays randomly integers : ");
        for (int i = 0; i < array.getArray().length; i++) {
            if (array.getArray()[i] != null) {
                System.out.print(array.getArray()[i] + " ");
            }
        }
        System.out.println();

        System.out.println("Enter K number : ");
        int K = new Reader(new ReadingDataUserInputInConsole()).readInt();

        int resultOfSumNumbersOfMultipleElement = (FINDING_SUM_ELEMENTS.getSumElements(array, K));

        System.out.println("Result : " + resultOfSumNumbersOfMultipleElement);

    }

    private static final FindingSumElements FINDING_SUM_ELEMENTS = (array, k) -> {
        int sumElements = 0;
        for (int i = 0; i < array.getArray().length; i++) {
            if (array.getArray()[i] != null) {
                if (array.getArray()[i] % k == 0) {
                    sumElements += array.getArray()[i];
                }
            }
        }
        return sumElements;
    };

}
