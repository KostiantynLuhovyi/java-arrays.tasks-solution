package com.lugowoy.tasks.onedimensional.findSubsetOfContiguousElementsOfArraySumOfValuesOfElementsWhichIsEqualToNumber;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingDataUserInputInConsole;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

import java.util.Objects;

/** Created by Konstantin Lugowoy on 18.06.2017. */

public class Main {

    private static final int BOUND = 10;

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray, BOUND));

        System.out.println("Original " + array);
        System.out.println();

        int number = getNumber();

        Findable<Array<Integer>, Integer> findable = Findable::findSubsetOfContiguousElementsOfArraySumOfValuesOfElementsWhichIsEqualToNumber;

        Integer[] resultIntegers = findable.find(array, number);

        if (resultIntegers != null) {

            Array<Integer> resultArray = new CreatorOfArrayModels<>(new FactoryOfIntegerArrayModels()).create(findable.find(array, number));

            if (Objects.nonNull(resultArray)) {
                if (resultArray.getArray() != null) {
                    System.out.println("Result : " + resultArray);
                } else {
                    System.out.println("An array does not contain such a sequence of elements.");
                }
            } else {
                System.out.println("Result array is null.");
            }
        } else {
            System.out.println("Result array is null.");
        }

    }

    private static int getNumber() {
        System.out.println("Enter number : ");
        int number;
        while (true) {
            number = new Reader(new ReadingDataUserInputInConsole()).readInt();
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
