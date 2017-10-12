package com.lugowoy.tasks.onedimensional.findLengthOfLongestSequenceOfElementsEqualToZero;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

/** Created by Konstantin Lugowoy on 18.06.2017. */

public class Main {

    private static final int BOUND = 3;

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray, BOUND));

        System.out.println("Original " + array);
        System.out.println();

        Findable<Integer, Array<Integer>> findable = Findable::findLengthOfLongestSequenceOfElementsEqualToZero;
        int resultZeroElementsToCount = findable.find(array);

        System.out.println("The longest sequence of consecutive array elements equal to zero is equal to " + resultZeroElementsToCount);

    }

}
