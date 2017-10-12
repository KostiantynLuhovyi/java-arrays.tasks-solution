package com.lugowoy.tasks.onedimensional.determiningTheIndexOfPrimesInAnArray;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

/** Created by Konstantin Lugowoy on 22.05.2017. */

public class Main {

    private static final int BOUND = 100;

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray, BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        System.out.println("The indexes of elements which are prime numbers : ");
        Determinable<Integer> determinable = Determinable::determineTheIndexOfPrimesInAnArray;
        for (int i = 0; i < array.getArray().length; i++) {
            if (determinable.determine(array.getArray()[i])) {
                System.out.print(i + " ");
            }
        }

    }

}
