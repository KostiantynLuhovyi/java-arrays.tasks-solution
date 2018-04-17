package com.lugowoy.tasks.onedimensional.determineWhetherItIsPossibleToSelectContiguousElementsInOneOfArraysByCondition;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

import java.util.List;

/** Created by Konstantin Lugowoy on 22.06.2017. */

public class Main {

    private static final FactoryArray<Integer> FACTORY = FactoryArray.getFactoryArray(new CreatorArrayNumbers<>());

    private static final int BOUND = 100;

    public static void main(String[] args) {

        System.out.println("Enter length of the first array : ");
        int lengthFirstArray = ArrayLength.getLengthArray(new ReadingConsole());

        System.out.println("Enter length of the second array : ");
        int lengthSecondArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<Integer> firstArray = FACTORY.create(new FillingArrayRandomIntegerNumbers().fill(lengthFirstArray, BOUND));
        Array<Integer> secondArray = FACTORY.create(new FillingArrayRandomIntegerNumbers().fill(lengthSecondArray, BOUND));

        Determinant<Array<Integer>> determine = Determinant::determineWhetherItIsPossibleToSelectContiguousElements;
        List<Array<Integer>> arrayList = determine.determine(firstArray, secondArray);

        if (!arrayList.isEmpty()) {
            System.out.println("Result : " + arrayList);
        } else {
            System.out.println("Result array is empty.");
        }

    }

}
