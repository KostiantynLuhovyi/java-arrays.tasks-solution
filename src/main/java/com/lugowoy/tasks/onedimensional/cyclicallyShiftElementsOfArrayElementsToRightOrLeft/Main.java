package com.lugowoy.tasks.onedimensional.cyclicallyShiftElementsOfArrayElementsToRightOrLeft;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthArray;

/** Created by Konstantin Lugowoy on 19.06.2017. */

public class Main {

    private static final Shifting<Array> SHIFTING = Shifting::shiftElementsOfArrayElementsToRightOrLeft;

    private static final int BOUND = 100;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> array = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, BOUND));

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
                System.err.println("The number must not be zero. Re-enter : ");
            } else {
                System.err.println("The number does not match the condition. Re-enter : ");
            }
        }
        return numberK;
    }

}
