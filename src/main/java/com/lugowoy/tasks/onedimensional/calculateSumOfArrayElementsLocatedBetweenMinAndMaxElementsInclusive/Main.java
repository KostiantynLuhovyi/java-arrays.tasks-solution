package com.lugowoy.tasks.onedimensional.calculateSumOfArrayElementsLocatedBetweenMinAndMaxElementsInclusive;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_NEGATIVE_BOUND;
import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_POSITIVE_BOUND;

/** Created by Konstantin Lugowoy on 27.03.2017. */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<Integer> array = FactoryArray.getFactoryArray(new CreatorArrayNumbers<Integer>()).create(
                                                                new FillingArrayRandomIntegerNumbers().fill(lengthArray,
                                                                                                            DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                                            DEFAULT_INTEGER_POSITIVE_BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        Determinant determinant = Determinant::determineMinElementIndex;
        int indexMinElement = determinant.determine(array);
        System.out.println("Index min element in the array is : " + indexMinElement);

        determinant = Determinant::determineMaxElementIndex;
        int indexMaxElement = determinant.determine(array);
        System.out.println("Index max element in the array is : " + indexMaxElement);

        System.out.println();

        Calculating calculating = Calculating::calculateSumOfArrayElementsLocatedBetweenMinAndMaxElementsInclusive;

        System.out.printf("Sum of array elements located between the min and max elements inclusive is : %d .",
                           calculating.calculate(array, indexMinElement, indexMaxElement));

    }

}
