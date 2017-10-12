package com.lugowoy.tasks.onedimensional.insertAnIntegerInTheSequencePositionWithoutViolatingTheIncrease;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingDataUserInputInConsole;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

import java.util.Arrays;

import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY;
import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY;

/** Created by Konstantin Lugowoy on 11.03.2017. */

public class Main {

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray, DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY, DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY));

        System.out.println("Original sequence : ");
        Arrays.stream(array.getArray()).forEachOrdered(integer -> System.out.print(integer + " "));
        System.out.println();

        System.out.println("Sorted sequence : ");
        Sortable<Integer> sortable = Sortable::sortingIntegerSequence;
        sortable.sort(array.getArray());
        Arrays.stream(array.getArray()).forEachOrdered(integer -> System.out.print(integer + " "));
        System.out.println();

        System.out.println("Enter numbers to insert : ");
        int insertNumber = new Reader(new ReadingDataUserInputInConsole()).readInt();
        System.out.println();

        System.out.println("Result sequence : ");
        Insertable<Integer> insertable = Insertable::insertElement;
        insertable.insert(insertNumber, array);
        Arrays.stream(array.getArray()).forEachOrdered(integer -> System.out.print(integer + " "));

    }

}
