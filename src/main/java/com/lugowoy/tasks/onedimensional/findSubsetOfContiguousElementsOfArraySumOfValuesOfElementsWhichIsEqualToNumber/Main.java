package com.lugowoy.tasks.onedimensional.findSubsetOfContiguousElementsOfArraySumOfValuesOfElementsWhichIsEqualToNumber;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_POSITIVE_BOUND;
import static com.lugowoy.helper.other.ArrayChecker.checkArrayNonNull;

/** Created by Konstantin Lugowoy on 18.06.2017. */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<Integer> array = FactoryArray.getFactoryArray(new CreatorArrayNumbers<Integer>()).create(
                                                                new FillingArrayRandomIntegerNumbers().fill(lengthArray,
                                                                                                            DEFAULT_INTEGER_POSITIVE_BOUND));

        System.out.println("Original " + array);
        System.out.println();

        int number = enterNumber();

        Finding<Array<Integer>, Integer> finding = Finding::findSubsetOfContiguousElementsOfArraySumOfValuesOfElementsWhichIsEqualToNumber;

        Array<Integer> resultArray = FactoryArray.getFactoryArray(new CreatorArrayNumbers<Integer>()).create(finding.find(array, number));

        try {
            if (checkArrayNonNull(resultArray)) {
                if (resultArray.getArray() != null) {
                    System.out.println("Result : " + resultArray);
                } else {
                    System.out.println("An array does not contain such a sequence of elements.");
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }

    }


    private static int enterNumber() {
        System.out.println("Enter number : ");
        Reader reader = Reader.getReader(new ReadingConsole());
        int number;
        while (true) {
            number = reader.readInt();
            if ((number >= 0) && (number <= 200)) {
                break;
            } else {
                System.out.println("Number must be a positive number.");
                System.out.println("Re-enter : ");
            }
        }
        return number;
    }

}
