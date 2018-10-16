package com.lugowoy.tasks.onedimensional.getIntegersInAscendingOrderThatDoesNotBelongToThisArray;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthArray;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 11.04.2017. */

public class Main {

    private static final int START_BOUND = -50;
    private static final int END_BOUND = 50;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> array = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, START_BOUND, END_BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        Finding<Integer, Array> finding = Finding::findMaxNumber;
        int maxNumberInTheArray = finding.find(array);
        System.out.println("Max number in the array : " + maxNumberInTheArray);

        finding = Finding::findMinNumber;
        int minNumberInTheArray = finding.find(array);
        System.out.println("Min number in the array : " + minNumberInTheArray);

        Array<Integer> arraySorted = Array.create(array.toArray(new Integer[array.getLength()]));

        Arrays.sort(arraySorted.toArray(new Integer[arraySorted.getLength()]));

        for (int j = minNumberInTheArray + 1; j < maxNumberInTheArray; j++) {
            if (!(Arrays.binarySearch(array.toArray(new Integer[array.getLength()]), j) > 0)) {
                System.out.print(j + " ");
            }
        }

    }

}
