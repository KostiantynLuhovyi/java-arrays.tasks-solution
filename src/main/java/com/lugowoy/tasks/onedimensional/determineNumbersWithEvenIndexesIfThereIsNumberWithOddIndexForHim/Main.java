package com.lugowoy.tasks.onedimensional.determineNumbersWithEvenIndexesIfThereIsNumberWithOddIndexForHim;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

/** Created by Konstantin Lugowoy on 07.05.2018. */

public class Main {

    private static final FactoryArray<Integer> FACTORY_ARRAY = FactoryArray.getFactoryArray(new CreatorArrayNumbers<>());

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<Integer> array = FACTORY_ARRAY.create(new FillingArrayRandomIntegerNumbers().fill(lengthArray));

        System.out.println("Array : " + array);

        Determinant determinant = Determinant::determineNumbersWithEvenIndexesIfThereIsNumberWithOddIndexForHim;
        determinant.determine(array);

    }

}
