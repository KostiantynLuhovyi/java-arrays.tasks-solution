package com.lugowoy.tasks.onedimensional.determineNumberOfLocalMaximaInArray;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthArray;

/** Created by Konstantin Lugowoy on 07.05.2018. */

public class Main {

    private static final int BOUND = 200;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> array = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, BOUND));

        System.out.println("Array : " + array);

        Determinant determinant = Determinant::determineNumbersOfLocalMaximum;
        determinant.determine(array);

    }

}
