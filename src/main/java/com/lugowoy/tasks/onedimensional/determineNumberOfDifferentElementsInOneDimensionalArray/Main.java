package com.lugowoy.tasks.onedimensional.determineNumberOfDifferentElementsInOneDimensionalArray;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthArray;

/** Created by Konstantin Lugowoy on 28.05.2017. */

public class Main {

    private static final Determinant<Integer> DETERMINANT = Determinant::determineTheNumberOfDifferentElementsInOneDimensionalArray;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> array = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray));

        System.out.println("Original array : " + array);
        System.out.println();

        int numberOfDifferentElements = DETERMINANT.determine(array);

        System.out.printf("In a one-dimensional array of %d different elements.", numberOfDifferentElements);

    }

}
