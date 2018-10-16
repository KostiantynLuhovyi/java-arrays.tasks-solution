package com.lugowoy.tasks.onedimensional.determineElementsThatAreEqualToHalfSumOfNeighboringElements;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthArray;

/** Created by Konstantin Lugowoy on 03.09.2017. */

public class Main {

    private static final Determinant DETERMINANT = Determinant::determineElementsThatAreEqualToHalfSumOfNeighboringElements;

    private static final int BOUND = 20;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> array = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, BOUND));

        System.out.println("Original array : " + array);

        System.out.println("Result : ");

        DETERMINANT.determine(array);

    }

}
