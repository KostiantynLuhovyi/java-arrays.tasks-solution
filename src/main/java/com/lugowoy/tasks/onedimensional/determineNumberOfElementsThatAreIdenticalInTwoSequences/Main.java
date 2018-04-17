package com.lugowoy.tasks.onedimensional.determineNumberOfElementsThatAreIdenticalInTwoSequences;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

/** Created by Konstantin Lugowoy on 30.05.2017. */

public class Main {

    private static final FactoryArray<Integer> FACTORY = FactoryArray.getFactoryArray(new CreatorArrayNumbers<>());

    private static final Determinant<Array<Integer>> DETERMINANT = Determinant::determineTheNumberOfElementsThatAreIdenticalInTwoSequences;

    private static final int BOUND = 50;

    public static void main(String[] args) {

        System.out.println("Enter length of the first array : ");
        int lengthFirstArray = ArrayLength.getLengthArray(new ReadingConsole());

        System.out.println("Enter length of the second array : ");
        int lengthSecondArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<Integer> firstArray = FACTORY.create(new FillingArrayRandomIntegerNumbers().fill(lengthFirstArray, BOUND));
        Array<Integer> secondArray = FACTORY.create(new FillingArrayRandomIntegerNumbers().fill(lengthSecondArray, BOUND));

        System.out.println("Elements of the first array : " + firstArray);
        System.out.println();

        System.out.println("Elements of the second array : " + secondArray);
        System.out.println();

        int numberOfIdenticalElementsInTheTwoSequence = DETERMINANT.determine(firstArray, secondArray);

        System.out.println("Number of identical elements in the two array : " + numberOfIdenticalElementsInTheTwoSequence);

    }

}
