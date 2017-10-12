package com.lugowoy.tasks.onedimensional.compressAnArrayByThrowingOutNullElements;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Created by Konstantin Lugowoy on 16.03.2017. */

public class Main {

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray, -10, 10));

        System.out.println("Original array : " + array);
        System.out.println();

        COMPRESSIBLE.compress(array);

        System.out.println();
        System.out.println("Result array : " + array);
    }

    private static final Compressible<Integer> COMPRESSIBLE = array -> {
        int numberZeroElements = 0;
        if (Objects.nonNull(array)) {
            if ((Objects.nonNull(array.getArray())) && (array.getArray().length > 0)) {
                List<Integer> list = new ArrayList<>(0);
                for (int i = 0; i < array.getArray().length; i++) {
                    if (array.getArray()[i] != 0) {
                        list.add(array.getArray()[i]);
                    } else {
                        numberZeroElements++;
                    }
                }
                array.setArray(list.toArray(new Integer[list.size()]));
            } else {
                System.out.println("The array is not valid for any operations or calculations.");
            }
        } else {
            System.out.println("The array is not valid for any operations or calculations.");
        }

        System.out.printf("Number of zero elements in the array : %d .", numberZeroElements);
        System.out.println();
    };

}
