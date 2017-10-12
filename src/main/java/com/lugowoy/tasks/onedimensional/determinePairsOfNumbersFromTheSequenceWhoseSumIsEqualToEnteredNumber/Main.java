package com.lugowoy.tasks.onedimensional.determinePairsOfNumbersFromTheSequenceWhoseSumIsEqualToEnteredNumber;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingDataUserInputInConsole;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

/** Created by Konstantin Lugowoy on 19.03.2017. */

public class Main {

    private static final Determinable<Integer> DETERMINABLE = Determinable::determinePairsOfNumbersFromTheSequenceWhoseSumIsEqualToEnteredNumber;

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray, 100));

        System.out.println(array);
        System.out.println();

        int sumNumber = enterNumber();

        DETERMINABLE.determine(array, sumNumber);

    }

    private static int enterNumber() {
        System.out.println("Enter number : ");
        return new Reader(new ReadingDataUserInputInConsole()).readInt();
    }

}
