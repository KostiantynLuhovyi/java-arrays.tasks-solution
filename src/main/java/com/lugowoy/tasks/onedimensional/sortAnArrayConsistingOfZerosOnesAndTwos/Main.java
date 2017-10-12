package com.lugowoy.tasks.onedimensional.sortAnArrayConsistingOfZerosOnesAndTwos;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

/** Created by Konstantin Lugowoy on 17.06.2017. */

public class Main {

    private static final int BOUND = 3;

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray, BOUND));

        System.out.println("Original " + array);

        Sortable<Array<Integer>> sortable = Sortable::sortArray;
        sortable.sort(array);

        System.out.println("After sort " + array);

    }

}
