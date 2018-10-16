package com.lugowoy.tasks.onedimensional.outputNumbersFromArrayThatSatisfyConditionForSolutionOfTask;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;
import com.lugowoy.helper.other.LengthArray;

/** Created by Konstantin Lugowoy on 25.04.2018. */

public class Main {

    private static final int BOUND = 20;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> array = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, BOUND));

        System.out.println("Array : " + array);

        System.out.println("Result : ");
        printExpressionWithNumbersSatisfyingCondition(array);

    }

    private static void printExpressionWithNumbersSatisfyingCondition(Array<Integer> array) {
        if (CheckerArray.checkArrayNonNull(array)
                && CheckerArray.checkLengthOfArrayIsGreaterZero(array.getLength())) {
            int countExpression = 0;
            for (int i = 0; i < array.getLength(); i++) {
                for (int j = i + 1; j < array.getLength(); j++) {
                    for (int k = 0; k < array.getLength(); k++) {
                        if (array.get(i) * array.get(j) == array.get(k)) {
                            System.out.printf("Expression: %d * %d = %d.\n", array.get(i), array.get(j), array.get(k));
                            countExpression++;
                        }
                    }
                }
            }
            if (countExpression == 0) {
                System.out.println("No numbers were found to evaluate the expression by condition.");
            }
        }
    }

}