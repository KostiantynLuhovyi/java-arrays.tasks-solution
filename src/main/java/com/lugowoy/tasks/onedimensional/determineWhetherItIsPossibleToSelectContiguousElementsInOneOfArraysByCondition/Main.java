package com.lugowoy.tasks.onedimensional.determineWhetherItIsPossibleToSelectContiguousElementsInOneOfArraysByCondition;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthArray;

import java.util.List;

/** Created by Konstantin Lugowoy on 22.06.2017. */

public class Main {

    private static final int BOUND = 100;

    public static void main(String[] args) {

        System.out.println("Enter length of the first array : ");
        int lengthOfFirstArray = LengthArray.getLengthOfArray(new ReadingConsole());

        System.out.println("Enter length of the second array : ");
        int lengthOfSecondArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> firstArray = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfFirstArray, BOUND));
        Array<Integer> secondArray = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfSecondArray, BOUND));

        Determinant<Array<Integer>> determine = Determinant::determineWhetherItIsPossibleToSelectContiguousElements;
        List<Array<Integer>> arrayList = determine.determine(firstArray, secondArray);

        if (!arrayList.isEmpty()) {
            System.out.println("Result : " + arrayList);
        } else {
            System.out.println("Result array is empty.");
        }

    }

}
