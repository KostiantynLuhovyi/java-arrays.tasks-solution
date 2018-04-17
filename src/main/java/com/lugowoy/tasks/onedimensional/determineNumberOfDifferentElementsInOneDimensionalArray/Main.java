package com.lugowoy.tasks.onedimensional.determineNumberOfDifferentElementsInOneDimensionalArray;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

/** Created by Konstantin Lugowoy on 28.05.2017. */

public class Main {

    private static final Determinant<Integer> DETERMINANT = Determinant::determineTheNumberOfDifferentElementsInOneDimensionalArray;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<Integer> array = FactoryArray.getFactoryArray(new CreatorArrayNumbers<Integer>()).create(
                                                                new FillingArrayRandomIntegerNumbers().fill(lengthArray));

        System.out.println("Original array : " + array);
        System.out.println();

        int numberOfDifferentElements = DETERMINANT.determine(array);

        System.out.printf("In a one-dimensional array of %d different elements.", numberOfDifferentElements);

    }

}
