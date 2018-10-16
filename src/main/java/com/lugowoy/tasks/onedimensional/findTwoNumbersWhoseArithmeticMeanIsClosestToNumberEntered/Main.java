package com.lugowoy.tasks.onedimensional.findTwoNumbersWhoseArithmeticMeanIsClosestToNumberEntered;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomDoubleNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthArray;

/** Created by Konstantin Lugowoy on 12.04.2017. */

public class Main {

    private static final double BOUND = 200d;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Double> array = Array.create(new FillingArrayRandomDoubleNumbers().fill(lengthOfArray, BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        System.out.println("Enter real number : ");
        double enterNumber = Reader.getReader(new ReadingConsole()).readDouble();

        Finding<Double, Array<Double>> findable = Finding::findTwoNumbersWhoseArithmeticMeanIsClosestToNumber;
        findable.find(enterNumber, array);

    }

}
