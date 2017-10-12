package com.lugowoy.tasks.onedimensional.compressTheArrayByThrowingEverySecondElement;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY;
import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY;

/** Created by Konstantin Lugowoy on 13.03.2017. */

public class Main {

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray, DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY, DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY));

        System.out.println("Original array : " + array);
        System.out.println();

        ARRAY_COMPRESSIBLE.compress(array);

        System.out.println("Result array : " + array);
        System.out.println();

    }

    private static final Compressible<Array<Integer>> ARRAY_COMPRESSIBLE = array -> {
        if (Objects.nonNull(array)) {
            if ((Objects.nonNull(array.getArray())) && (array.getArray().length >= 2)) {
                List<Integer> integerList = new ArrayList<>(0);
                for (int i = 0; i < array.getArray().length; i++) {
                    if ((i % 2 == 0) || (i == 0)) {
                        integerList.add(array.getArray()[i]);
                    }
                }
                    array.setArray(integerList.stream().mapToInt(Integer::intValue).boxed().toArray(Integer[]::new));
            } else {
                System.out.println("The array is not valid for any operations or calculations.");
            }
        } else {
            System.out.println("The array is not valid for any operations or calculations.");
        }
    };

}
