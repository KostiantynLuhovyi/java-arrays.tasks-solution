package com.lugowoy.tasks.onedimensional.findTwoNumbersWhoseArithmeticMeanIsClosestToTheNumberEntered;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfDoubleArrayModels;
import com.lugowoy.helper.filling.FillingArrayDoubleRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingDataUserInputInConsole;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

/** Created by Konstantin Lugowoy on 12.04.2017. */

public class Main {

    private static final double BOUND = 200.0;

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Double> array = new CreatorOfArrayModels<>(
                                    new FactoryOfDoubleArrayModels()).create(
                                            new FillingArrayDoubleRandomNumbers().fill(sizeArray, BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        System.out.println("Enter real number : ");
        double enterNumber = new Reader(new ReadingDataUserInputInConsole()).readDouble();

        Findable<Double, Array<Double>> findable = Findable::findTwoNumbersWhoseArithmeticMeanIsClosestToTheNumber;
        findable.find(enterNumber, array);

    }

}
