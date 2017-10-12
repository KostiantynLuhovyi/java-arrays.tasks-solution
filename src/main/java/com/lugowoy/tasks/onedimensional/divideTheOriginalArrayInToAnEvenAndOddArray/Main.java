package com.lugowoy.tasks.onedimensional.divideTheOriginalArrayInToAnEvenAndOddArray;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

/** Created by Konstantin Lugowoy on 16.03.2017. */

public class Main {

    private static final int BOUND = 200;

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> originalArray = new CreatorOfArrayModels<>(
                                            new FactoryOfIntegerArrayModels()).create(
                                                    new FillingArrayIntegerRandomNumbers().fill(sizeArray, BOUND));

        System.out.println("Original array : " + originalArray);
        System.out.println();

        Selectable<Array<Integer>> selectable = Selectable::selectableArray;

        Array<Integer> evenNumbersArray = selectable.select(originalArray, Selectable.STATUS_EVEN_NUMBERS);
        Array<Integer> oddNumbersArray = selectable.select(originalArray, Selectable.STATUS_ODD_NUMBERS);

        System.out.println("Even number array created based on the original array : ");
        System.out.println(evenNumbersArray);
        System.out.println();

        System.out.println("Odd number array created based on the original array : ");
        System.out.println(oddNumbersArray);
        System.out.println();

    }

}
