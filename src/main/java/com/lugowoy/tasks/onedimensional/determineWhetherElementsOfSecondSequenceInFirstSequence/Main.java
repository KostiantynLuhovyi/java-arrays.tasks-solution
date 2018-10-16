package com.lugowoy.tasks.onedimensional.determineWhetherElementsOfSecondSequenceInFirstSequence;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthArray;

/** Created by Konstantin Lugowoy on 12.04.2017. */

public class Main {

    private static final Determinant<Array<Integer>> DETERMINANT = Determinant::determineWhetherTheElementsOfTheSecondSequenceInTheFirstSequence;

    private static final int BOUND = 50;

    public static void main(String[] args) {

        System.out.println("Enter length of the first array : ");
        int lengthOfFirstArray = LengthArray.getLengthOfArray(new ReadingConsole());

        System.out.println("Enter length of the second array : ");
        int lengthSecondArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> firstArray = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfFirstArray, BOUND));
        Array<Integer> secondArray = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthSecondArray, BOUND));

        System.out.println("First array : " + firstArray);
        System.out.println();

        System.out.println("Second array : " + secondArray);
        System.out.println();

        boolean resultDetermine = DETERMINANT.determine(firstArray, secondArray);

        if (resultDetermine) {
            System.out.println("Elements of the second sequence are included in the first sequence.");
        } else {
            System.out.println("Elements of the second sequence are not included in the first sequence.");
        }

    }

}
