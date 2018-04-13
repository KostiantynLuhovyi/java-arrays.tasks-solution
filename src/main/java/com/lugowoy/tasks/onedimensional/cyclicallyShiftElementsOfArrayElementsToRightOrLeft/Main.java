package com.lugowoy.tasks.onedimensional.cyclicallyShiftElementsOfArrayElementsToRightOrLeft;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

/** Created by Konstantin Lugowoy on 19.06.2017. */

public class Main {

    private static final Shifting<Array> SHIFTING = Shifting::shiftElementsOfArrayElementsToRightOrLeft;

    private static final int BOUND = 100;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<Integer> array = FactoryArray.getFactoryArray(new CreatorArrayNumbers<Integer>()).create(
                                                                new FillingArrayRandomIntegerNumbers().fill(lengthArray, BOUND));

        System.out.println("Original : " + array);

        int numberK = enterNumberK(array.getLength());

        SHIFTING.shift(array, numberK);

        System.out.println("Result after shifting elements : " + array);

    }

    private static int enterNumberK(int sizeArray) {
        System.out.println("Enter integer number : ");
        Reader reader = Reader.getReader(new ReadingConsole());
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
