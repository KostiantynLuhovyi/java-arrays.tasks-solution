package com.lugowoy.tasks.onedimensional.createArrayOfEvenNumbersBasedOnAnotherArray;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

import java.util.Arrays;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_NEGATIVE_BOUND;
import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_POSITIVE_BOUND;
import static com.lugowoy.helper.other.ArrayChecker.checkArrayNonNull;
import static com.lugowoy.helper.other.ArrayChecker.checkLengthOfArrayIsGreaterZero;

/**Created by Konstantin Lugowoy on 13-Feb-17.*/

public class Main {

    private static final FactoryArray<Integer> FACTORY = FactoryArray.getFactoryArray(new CreatorArrayNumbers<>());

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<Integer> array = FACTORY.create(new FillingArrayRandomIntegerNumbers().fill(lengthArray, DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                                       DEFAULT_INTEGER_POSITIVE_BOUND));

        System.out.println("Original array numbers : " + array);

        Array<Integer> evenNumbersArray = getArrayWithEvenNumbers(array);

        System.out.println("Even numbers of original array : " + evenNumbersArray);

    }

    private static Array<Integer> getArrayWithEvenNumbers(Array<Integer> array) {
        Array<Integer> resultArray = FACTORY.create(0);
        try {
            if (checkArrayNonNull(array)) {
                if (checkArrayNonNull(array.getArray()) && checkLengthOfArrayIsGreaterZero(array.getLength())) {
                    for (int i = 0; i < array.getLength(); i++) {
                        if (array.get(i) % 2 == 0) {
                            resultArray.add(array.get(i));
                        }
                    }
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        return resultArray;
    }

}
