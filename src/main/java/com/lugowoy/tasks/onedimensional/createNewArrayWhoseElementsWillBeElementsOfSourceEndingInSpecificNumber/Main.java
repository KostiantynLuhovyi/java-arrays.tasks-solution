package com.lugowoy.tasks.onedimensional.createNewArrayWhoseElementsWillBeElementsOfSourceEndingInSpecificNumber;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingDataUserInputInConsole;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

import java.util.ArrayList;
import java.util.List;

/** Created by Konstantin Lugowoy on 27.03.2017. */

public class Main {

    private static Reader reader = new Reader(new ReadingDataUserInputInConsole());

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                                            new FillingArrayIntegerRandomNumbers().fill(sizeArray, Integer.MAX_VALUE));

        System.out.println("Original : \n" + array);
        System.out.println();

        System.out.println("Enter specific ending number : ");
        int specificEndingNumber = reader.readInt();

        Array newArray = createNewArrayWhoseElementsWillBeElementsOfSourceEndingInSpecificNumber(array, specificEndingNumber);

        System.out.println("New : \n" + newArray);
        System.out.println();

    }

    private static Array<Integer> createNewArrayWhoseElementsWillBeElementsOfSourceEndingInSpecificNumber(Array<Integer> array, int specificEndingNumber) {
        List<Integer> resultNewIntegerList = new ArrayList<>(0);

        if (array != null) {
            if ((array.getArray() != null) && (array.getArray().length > 0)) {
                for (int i : array.getArray()) {
                    if (Math.abs(i) % 10 == specificEndingNumber) {
                        resultNewIntegerList.add(i);
                    }
                }
            } else {
                System.out.println("Incorrect argument passed.");
            }
        } else {
            System.out.println("Incorrect argument passed.");
        }
        return new CreatorOfArrayModels<>(new FactoryOfIntegerArrayModels()).create(resultNewIntegerList.stream().toArray(Integer[]::new));
    }

}
