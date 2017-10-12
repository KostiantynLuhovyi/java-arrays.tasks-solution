package com.lugowoy.tasks.onedimensional.createAnArrayOfEvenNumbersBasedOnAnotherArray;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

import java.util.ArrayList;
import java.util.Arrays;

import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY;

/**Created by Konstantin Lugowoy on 13-Feb-17.*/

public class Main {

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray, DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY));

        System.out.println("Original array numbers.");
        Arrays.stream(array.getArray()).forEachOrdered(integer -> System.out.print(integer + " "));

        Array<Integer> evenNumbersArray = new CreatorOfArrayModels<>(
                                                new FactoryOfIntegerArrayModels()).create(getEvenNumbersArray(array));

        System.out.println();
        System.out.println("Even numbers of original array.");
        Arrays.stream(evenNumbersArray.getArray()).forEachOrdered(integer -> System.out.print(integer + " "));

    }

    private static Integer[] getEvenNumbersArray(Array<Integer> array) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < array.getArray().length; i++) {
            if (array.getArray()[i] % 2 == 0) integers.add(array.getArray()[i]);
        }
        return Arrays.stream(integers.stream()
                                     .mapToInt(Integer::intValue)
                                     .toArray())
                     .boxed()
                     .toArray(Integer[]::new);
    }

}
