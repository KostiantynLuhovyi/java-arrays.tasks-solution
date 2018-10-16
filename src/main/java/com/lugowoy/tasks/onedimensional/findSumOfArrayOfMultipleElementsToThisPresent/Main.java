package com.lugowoy.tasks.onedimensional.findSumOfArrayOfMultipleElementsToThisPresent;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;
import com.lugowoy.helper.other.LengthArray;

/**Created by Konstantin Lugowoy on 12-Feb-17.*/

public class Main {

    private static final int BOUND = 50;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> array = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, BOUND));

        System.out.println("Result fill arrays randomly integers : ");
        for (int i = 0; i < array.getLength(); i++) {
            if (array.get(i) != null) {
                System.out.print(array.get(i) + " ");
            }
        }
        System.out.println();

        System.out.println("Enter K number : ");
        int K = Reader.getReader(new ReadingConsole()).readInt();

        int resultOfSumNumbersOfMultipleElement = (FINDING_SUM_ELEMENTS.calculateSumOfElements(array, K));

        System.out.println("Result : " + resultOfSumNumbersOfMultipleElement);

    }

    private static final Finding FINDING_SUM_ELEMENTS = (array, k) -> {
        int sumElements = 0;
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsGreaterZero(array.getLength())) {
                for (int i = 0; i < array.getLength(); i++) {
                    if (array.get(i) != null) {
                        if (array.get(i) % k == 0) {
                            sumElements += array.get(i);
                        }
                    }
                }
            }
        }
        return sumElements;
    };

}
