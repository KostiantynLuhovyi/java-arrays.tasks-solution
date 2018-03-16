package com.lugowoy.tasks.onedimensional.createArrayOfZeroElementsOfAnotherArray;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_NEGATIVE_BOUND;
import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_POSITIVE_BOUND;
import static com.lugowoy.helper.other.ArrayChecker.checkArrayNonNull;
import static com.lugowoy.helper.other.ArrayChecker.checkLengthOfArrayIsGreaterZero;

/**Created by Konstantin Lugowoy on 12-Feb-17.*/

public class Main {

    private static final FactoryArray<Integer> FACTORY = FactoryArray.getFactoryArray(new CreatorArrayNumbers<>());

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<Integer> originalIntegerArray = FACTORY.create(new FillingArrayRandomIntegerNumbers().fill(lengthArray,
                                                                                                         DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                                         DEFAULT_INTEGER_POSITIVE_BOUND));

        System.out.println("Elements of of the original array : " + originalIntegerArray);
        System.out.println();

        Array<Integer> integerArrayIndexZero = FACTORY.create(FILLING_ARRAY.fillArray(originalIntegerArray).getArray());

        System.out.print("Index of zero elements of the original array : ");
        if (integerArrayIndexZero.getArray().length != 0) {
            for (int i = 0; i < integerArrayIndexZero.getArray().length; i++) {
                System.out.print(integerArrayIndexZero.getArray()[i] + " ");
            }
        } else {
            System.out.println("It does not contain zero elements.");
        }

    }

    private static final FillingArray<Integer> FILLING_ARRAY = originalArray -> {
        Array<Integer> tmpArray = FACTORY.create(0);
        try {
            if (checkArrayNonNull(originalArray)) {
                if (checkArrayNonNull(originalArray.getArray())
                        && checkLengthOfArrayIsGreaterZero(originalArray.getLength())) {
                    for (int i = 0; i < originalArray.getLength(); i++) {
                        if (originalArray.get(i) == 0) {
                            tmpArray.add(i);
                        }
                    }
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        return tmpArray;
    };

}
