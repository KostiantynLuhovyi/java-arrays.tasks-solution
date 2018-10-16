package com.lugowoy.tasks.onedimensional.sortArrayConsistingOfZerosOnesAndTwos;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthArray;

/** Created by Konstantin Lugowoy on 17.06.2017. */

public class Main {

    private static final int BOUND = 3;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> array = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, BOUND));

        System.out.println("Original " + array);

        Sorting<Array<Integer>> sorting = Sorting::sortArray;
        sorting.sort(array);

        System.out.println("After sort " + array);

    }

}
