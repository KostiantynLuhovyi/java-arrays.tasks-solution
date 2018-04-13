package com.lugowoy.tasks.onedimensional.calculateSumOfMaxAndMinElementOfThisParticularSequence;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_NEGATIVE_BOUND;
import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_POSITIVE_BOUND;

/** Created by Konstantin Lugowoy on 01.03.2017. */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<Integer> array = FactoryArray.getFactoryArray(new CreatorArrayNumbers<Integer>()).create(
                                                                new FillingArrayRandomIntegerNumbers().fill(lengthArray,
                                                                                                            DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                                            DEFAULT_INTEGER_POSITIVE_BOUND));

        System.out.println("Original : " + array);
        System.out.println();

        Determinant<Array<Integer>, Integer> determinant = Determinant::determineMaxElement;
        int maxElement = determinant.determine(array);
        System.out.println("Max element in the array is " + maxElement);

        determinant = Determinant::determineMinElement;
        int minElement = determinant.determine(array);
        System.out.println("Min element in the array is " + minElement);

        System.out.println();

        System.out.println("Result summation : " + (maxElement + minElement));

    }

}
