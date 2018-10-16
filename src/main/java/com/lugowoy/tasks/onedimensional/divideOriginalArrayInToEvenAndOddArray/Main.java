package com.lugowoy.tasks.onedimensional.divideOriginalArrayInToEvenAndOddArray;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthArray;

/** Created by Konstantin Lugowoy on 16.03.2017. */

public class Main {

    private static final int BOUND = 200;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> originalArray = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, BOUND));

        System.out.println("Original array : " + originalArray);
        System.out.println();

        Selecting<Array<Integer>> selecting = Selecting::selectArray;

        Array<Integer> evenNumbersArray = selecting.select(originalArray, Selecting.STATUS_EVEN_NUMBERS);
        Array<Integer> oddNumbersArray = selecting.select(originalArray, Selecting.STATUS_ODD_NUMBERS);

        System.out.println("Even number array created based on the original array : " + evenNumbersArray);
        System.out.println();

        System.out.println("Odd number array created based on the original array : " + oddNumbersArray);

    }

}
