package com.lugowoy.tasks.onedimensional.findSubsetOfContiguousElementsOfArraySumOfValuesOfElementsWhichIsEqualToNumber;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;
import com.lugowoy.helper.other.LengthArray;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;

/** Created by Konstantin Lugowoy on 18.06.2017. */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> array = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, POSITIVE_INTEGER_BOUND));

        System.out.println("Original " + array);
        System.out.println();

        int number = enterNumber();

        Finding<Array<Integer>, Integer> finding = Finding::findSubsetOfContiguousElementsOfArraySumOfValuesOfElementsWhichIsEqualToNumber;

        Array<Integer> resultArray = Array.create(finding.find(array, number));

        if (CheckerArray.checkArrayNonNull(resultArray)
                && CheckerArray.checkLengthOfArrayIsEqualToOrGreaterThanZero(resultArray.getLength())) {
            System.out.println("Result : " + resultArray);
        } else {
            System.out.println("An array does not contain such a sequence of elements.");
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
