package com.lugowoy.tasks.onedimensional.createNewArrayWhoseElementsWillBeElementsOfSourceEndingInSpecificNumber;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;
import com.lugowoy.helper.other.LengthArray;

/** Created by Konstantin Lugowoy on 27.03.2017. */

public class Main {

    private static final int START_BOUND = -10000;
    private static final int END_BOUND = 10000;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> array = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, START_BOUND, END_BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        System.out.println("Enter specific ending number : ");
        int specificEndingNumber = Reader.getReader(new ReadingConsole()).readInt();

        Array<Integer> newArray = createNewArrayWhoseElementsWillBeElementsOfSourceEndingInSpecificNumber(array, specificEndingNumber);

        System.out.println("New array : " + newArray);
        System.out.println();

    }

    private static Array<Integer> createNewArrayWhoseElementsWillBeElementsOfSourceEndingInSpecificNumber(Array<Integer> array, int specificEndingNumber) {
        Array<Integer> resultArray = Array.create(0);
        if (CheckerArray.checkArrayNonNull(array)) {
            if (CheckerArray.checkLengthOfArrayIsGreaterZero(array.getLength())) {
                for (int i = 0; i < array.getLength(); i++) {
                    if (Math.abs(array.get(i)) % 10 == specificEndingNumber) {
                        resultArray.add(array.get(i));
                    }
                }
            }
        }
        return resultArray;
    }

}
