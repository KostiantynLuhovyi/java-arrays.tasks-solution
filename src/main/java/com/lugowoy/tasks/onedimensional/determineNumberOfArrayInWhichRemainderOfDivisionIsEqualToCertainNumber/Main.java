package com.lugowoy.tasks.onedimensional.determineNumberOfArrayInWhichRemainderOfDivisionIsEqualToCertainNumber;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.ArrayOfNumbers;
import com.lugowoy.helper.other.ArrayLength;

/**Created by Konstantin Lugowoy on 14-Feb-17.*/

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    private static final int START_BOUND = -200;
    private static final int END_BOUND = 300;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        ArrayOfNumbers<Integer> array = (ArrayOfNumbers<Integer>) FactoryArray.getFactoryArray(new CreatorArrayNumbers<Integer>()).create(
                                                                                                new FillingArrayRandomIntegerNumbers().fill(lengthArray,
                                                                                                                                            START_BOUND,
                                                                                                                                            END_BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        System.out.println("Enter number to the modulo : ");
        int numberToModulo = READER.readInt();

        System.out.println("Enter result to the modulo : ");
        int resultModulo = READER.readInt();

        DETERMINANT.determinate(array, numberToModulo, resultModulo);
    }

    private static final Determinant DETERMINANT = (array, numberToModulo, resultModulo) -> {
        System.out.println("Result to the modulo operation : ");
        int countResult = 0;
        for (int number : array.toArray(new Integer[array.getLength()])) {
            if (number % numberToModulo == resultModulo) {
                System.out.print(number + " ");
            } else {
                countResult++;
            }
        }
        if (countResult == array.getLength()) {
            System.out.println("No numbers which satisfy the condition.");
        }
    };

}
