package com.lugowoy.tasks.onedimensional.determineIndexOfPrimeNumbersInArray;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

/** Created by Konstantin Lugowoy on 22.05.2017. */

public class Main {

    private static final Determinant<Integer> DETERMINANT = Determinant::determineTheIndexOfPrimesInAnArray;

    private static final int BOUND = 100;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<Integer> array = FactoryArray.getFactoryArray(new CreatorArrayNumbers<Integer>()).create(
                                                                new FillingArrayRandomIntegerNumbers().fill(lengthArray,
                                                                                                            BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        System.out.println("The indexes of elements which are prime numbers : ");
        for (int i = 0; i < array.getLength(); i++) {
            if (DETERMINANT.determine(array.get(i))) {
                System.out.print(i + ", ");
            }
        }

    }

}
