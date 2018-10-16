package com.lugowoy.tasks.onedimensional.determinePairsOfNumbersFromSequenceWhoseSumIsEqualToEnteredNumber;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthArray;

/** Created by Konstantin Lugowoy on 19.03.2017. */

public class Main {

    private static final Determinant<Integer> DETERMINANT = Determinant::determinePairsOfNumbersFromTheSequenceWhoseSumIsEqualToEnteredNumber;

    private static final int BOUND = 100;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> array = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, BOUND));

        System.out.println(array);
        System.out.println();

        int sumNumber = enterNumber();

        DETERMINANT.determine(array, sumNumber);

    }

    private static int enterNumber() {
        System.out.println("Enter number : ");
        return Reader.getReader(new ReadingConsole()).readInt();
    }

}
