package com.lugowoy.tasks.onedimensional.findNumbersInSequenceThatAreTheSquareOfNumber;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingDataUserInputInConsole;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

/** Created by Konstantin Lugowoy on 12.03.2017. */

public class Main {

    private static final int BOUND = 50;

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray, BOUND));

        System.out.println("Original sequence : " + array);
        System.out.println();

        System.out.println("Enter a number to compare : ");
        int compareNumber = new Reader(new ReadingDataUserInputInConsole()).readInt();

        System.out.println("Result : ");
        int quantityResult = 0;
        for (int i = 0; i < array.getArray().length; i++) {
            int number = array.getArray()[i];
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
