package com.lugowoy.tasks.onedimensional.determineGreatestCommonDivisorForArrayOfNumbers;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

/** Created by Konstantin Lugowoy on 09.05.2018. */

public class Main {

    private static final FactoryArray<Integer> FACTORY_ARRAY = FactoryArray.getFactoryArray(new CreatorArrayNumbers<Integer>());

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<Integer> array = FACTORY_ARRAY.create(new FillingArrayRandomIntegerNumbers().fill(lengthArray));

        System.out.println("Array : " + array);

        print(DeterminantGreatestCommonDivisor::determineGreatestCommonDivisor, array);

    }

    private static void print(DeterminantGreatestCommonDivisor determinantGCD, Array<Integer> array) {
        System.out.println("Greatest common divisor of the array is : " + determinantGCD.determine(array));
    }

}
