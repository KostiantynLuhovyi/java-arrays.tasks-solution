package com.lugowoy.tasks.onedimensional.determineWhetherTheElementsOfTheSecondSequenceInTheFirstSequence;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

/** Created by Konstantin Lugowoy on 12.04.2017. */

public class Main {

    private static final CreatorOfArrayModels<Integer> CREATOR = new CreatorOfArrayModels<>(new FactoryOfIntegerArrayModels());
    private static final int BOUND = 50;

    public static void main(String[] args) {

        System.out.println("First array.");
        int sizeToFirstArray = DeterminatorSizeOfArray.determineSizeOfArray();

        System.out.println("Second array.");
        int sizeToSecondArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> firstArray = CREATOR.create(new FillingArrayIntegerRandomNumbers().fill(sizeToFirstArray, BOUND));
        Array<Integer> secondArray = CREATOR.create(new FillingArrayIntegerRandomNumbers().fill(sizeToSecondArray, BOUND));

        System.out.println("First array : " + firstArray);
        System.out.println();

        System.out.println("Second array : " + secondArray);
        System.out.println();

        Determinable<Array<Integer>> determinable = Determinable::determineWhetherTheElementsOfTheSecondSequenceInTheFirstSequence;
        boolean resultDetermine = determinable.determine(firstArray, secondArray);

        if (resultDetermine) {
            System.out.println("Elements of the second sequence are included in the first sequence.");
        } else {
            System.out.println("Elements of the second sequence are not included in the first sequence.");
        }

    }

}
