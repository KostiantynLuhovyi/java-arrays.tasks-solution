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

        System.out.println("Original array numbers.");
        Arrays.stream(array.getArray()).forEachOrdered(integer -> System.out.print(integer + " "));

        Array<Integer> evenNumbersArray = FACTORY.create(getEvenNumbersArray(array));

        System.out.println();
        System.out.println("Even numbers of original array.");
        Arrays.stream(evenNumbersArray.getArray()).forEachOrdered(integer -> System.out.print(integer + " "));

    }

    private static Integer[] getEvenNumbersArray(Array<Integer> array) {
        Array<Integer> tmpArray = FACTORY.create(0);
        try {
            if (checkArrayNonNull(array)) {
                if (checkArrayNonNull(array.getArray()) && checkLengthOfArrayIsGreaterZero(array.getLength())) {
                    for (int i = 0; i < array.getLength(); i++) {
                        if (array.get(i) % 2 == 0) {
                            tmpArray.add(array.get(i));
                        }
                    }
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        return tmpArray.getArray();
    }

}
