package com.lugowoy.tasks.onedimensional.cyclicallyShiftElementsOfArrayElementsKtoRightOrLeft;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingDataUserInputInConsole;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

/** Created by Konstantin Lugowoy on 19.06.2017. */

public class Main {

    private static Reader reader = new Reader(new ReadingDataUserInputInConsole());

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray, 100));

        System.out.println("Original " + array);

        int numberK = getNumberK(array.getArray().length);

        System.out.println("Number : " + numberK);

        Shiftable<Array> shiftable = Shiftable::shiftElementsOfArrayElementsToRightOrLeft;
        shiftable.shift(array, numberK);

        System.out.println("Result after shifting elements : ");
        System.out.println(array);

    }

    private static int getNumberK(int sizeArray) {
        System.out.println("Enter integer number : ");
        int numberK;
        while (true) {
            numberK = reader.readInt();
            if ((numberK >= sizeArray) || (numberK > -sizeArray)) {
                break;
            } else if (numberK == 0) {
                System.out.println("The number must not be zero.");
                System.out.println("Re-enter : ");
            } else {
                System.out.println("The number does not match the condition.");
                System.out.println("Re-enter : ");
            }
        }
        return numberK;
    }

}
