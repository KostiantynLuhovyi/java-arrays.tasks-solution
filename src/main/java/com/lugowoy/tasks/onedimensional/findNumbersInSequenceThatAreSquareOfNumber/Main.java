package com.lugowoy.tasks.onedimensional.findNumbersInSequenceThatAreSquareOfNumber;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthArray;

/** Created by Konstantin Lugowoy on 12.03.2017. */

public class Main {

    private static final int BOUND = 50;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> array = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, BOUND));

        System.out.println("Original sequence : " + array);
        System.out.println();

        System.out.println("Enter a number to compare : ");
        int compareNumber = Reader.getReader(new ReadingConsole()).readInt();

        System.out.println("Result : ");
        int quantityResult = 0;
        for (int i = 0; i < array.getLength(); i++) {
            int number = array.get(i);
            int squareRootNumber = (int)Math.pow(number, 2);
            if (compareNumber == squareRootNumber) {
                System.out.printf("Sequence index : %d, element : %d", i,number);
                quantityResult++;
            }
        }
        if (quantityResult == 0) {
            System.out.println("There are no numbers in the sequence satisfying condition.");
        }
    }

}
