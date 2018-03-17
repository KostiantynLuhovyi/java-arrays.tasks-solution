package com.lugowoy.tasks.onedimensional.findLengthOfLongestSequenceOfElementsEqualToZero;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

/** Created by Konstantin Lugowoy on 18.06.2017. */

public class Main {

    private static final int BOUND = 3;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<Integer> array = FactoryArray.getFactoryArray(new CreatorArrayNumbers<Integer>()).create(
                                                                new FillingArrayRandomIntegerNumbers().fill(lengthArray,
                                                                                                            BOUND));

        System.out.println("Original " + array);
        System.out.println();

        Finding<Integer, Array<Integer>> finding = Finding::findLengthOfLongestSequenceOfElementsEqualToZero;
        int resultZeroElementsToCount = finding.find(array);

        System.out.println("The longest sequence of consecutive array elements equal to zero is equal to "
                                                                                           + resultZeroElementsToCount);

    }

}
