package com.lugowoy.tasks.onedimensional.determineWhetherItIsPossibleToSelectContiguousElementsInOneOfArraysByCondition;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

import java.util.Arrays;
import java.util.List;

/** Created by Konstantin Lugowoy on 22.06.2017. */

public class Main {

    private static final CreatorOfArrayModels<Integer> CREATOR = new CreatorOfArrayModels<>(new FactoryOfIntegerArrayModels());
    private static final int BOUND = 100;

    public static void main(String[] args) {

        System.out.println("First array.");
        int sizeToFirstArray = DeterminatorSizeOfArray.determineSizeOfArray();

        System.out.println("Second array.");
        int sizeToSecondArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> firstArray = CREATOR.create(new FillingArrayIntegerRandomNumbers().fill(sizeToFirstArray, BOUND));
        Array<Integer> secondArray = CREATOR.create(new FillingArrayIntegerRandomNumbers().fill(sizeToSecondArray, BOUND));

        Determine<Array<Integer>> determine = Determine::determineWhetherItIsPossibleToSelectContiguousElements;
        List<Array<Integer>> arrayList = determine.determine(firstArray, secondArray);

        if (!arrayList.isEmpty()) {
            System.out.println("Result : ");
            arrayList.forEach(array -> System.out.println(Arrays.toString(array.getArray()) + " "));
        } else {
            System.out.println("Result array is empty.");
        }

    }

}
