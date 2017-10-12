package com.lugowoy.tasks.onedimensional.determineTheNumberOfTheArrayInWhichTheRemainderOfTheDivisionIsEqualToCertainNumber;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.arrays.ArrayOfIntegerNumbers;
import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingDataUserInputInConsole;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

/**Created by Konstantin Lugowoy on 14-Feb-17.*/

public class Main {

    private static Reader reader = new Reader(new ReadingDataUserInputInConsole());

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray, -200, 300));

        System.out.println("Original array : " + array);
        System.out.println();

        System.out.println("Enter number to the modulo : ");
        int numberToModulo = reader.readInt();

        System.out.println("Enter result to the modulo : ");
        int resultModulo = reader.readInt();

        DETERMINABLE.determinate(((ArrayOfIntegerNumbers)array).getArrayOfIntegerPrimitiveNumbers(), numberToModulo, resultModulo);
    }

    private static final Determinable DETERMINABLE = (numbers, numberToModulo, resultModulo) -> {
        System.out.println("Result to the modulo operation : ");
        int countResult = 0;
        for (int number : numbers) {
            if (number % numberToModulo == resultModulo) {
                System.out.print(number + " ");
            } else {
                countResult++;
            }
        }
        if (countResult == numbers.length) {
            System.out.println("No numbers which satisfy the condition.");
        }
    };

}
