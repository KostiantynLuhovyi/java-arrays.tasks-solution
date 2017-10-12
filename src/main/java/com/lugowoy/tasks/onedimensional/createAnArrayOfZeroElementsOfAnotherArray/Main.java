package com.lugowoy.tasks.onedimensional.createAnArrayOfZeroElementsOfAnotherArray;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**Created by Konstantin Lugowoy on 12-Feb-17.*/

public class Main {

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> originalIntegerArray = new CreatorOfArrayModels<>(
                                                    new FactoryOfIntegerArrayModels()).create(
                                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray, -10, 10));

        System.out.println("Elements of of the original array : " + originalIntegerArray);
        System.out.println();

        Array<Integer> integerArrayIndexZero = new CreatorOfArrayModels<>(new FactoryOfIntegerArrayModels()).create();

        integerArrayIndexZero.setArray(fillingArrayOfAnotherArrayElementsZero.fillArrayOfAnotherArrayElementsZero(originalIntegerArray.getArray()));

        System.out.print("Index of zero elements of the original array : ");
        if (integerArrayIndexZero.getArray().length != 0) {
            for (int i = 0; i < integerArrayIndexZero.getArray().length; i++) {
                System.out.print(integerArrayIndexZero.getArray()[i] + " ");
            }
        } else {
            System.out.println("It does not contain zero elements.");
        }

    }

    private static FillingArrayOfAnotherArrayElementsZero<Integer> fillingArrayOfAnotherArrayElementsZero = originalArray -> {
        ArrayList<Integer> integers = new ArrayList<>();
        Integer[] resultArray;
        if (Objects.nonNull(originalArray)) {
            for (int i = 0; i < originalArray.length; i++) {
                if (originalArray[i] == 0) {
                    integers.add(i);
                }
            }
        } else {
            System.out.println("The array is not valid for any operations or calculations.");
        }

        if (integers.isEmpty()) {
            resultArray = new Integer[0];
        } else {
            resultArray = Arrays.stream(
                    integers
                            .stream()
                            .mapToInt(Integer::intValue)
                            .toArray())
                    .boxed()
                    .toArray(Integer[]::new);

        }
        return resultArray;
    };

}
