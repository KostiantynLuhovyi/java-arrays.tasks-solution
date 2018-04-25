package com.lugowoy.tasks.onedimensional.outputNumbersFromArrayThatSatisfyConditionForSolutionOfTask;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

import static com.lugowoy.helper.other.ArrayChecker.checkArrayNonNull;
import static com.lugowoy.helper.other.ArrayChecker.checkLengthOfArrayIsGreaterZero;

/** Created by Konstantin Lugowoy on 25.04.2018. */

public class Main {

    private static final int BOUND = 20;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<Integer> array = FactoryArray.getFactoryArray(new CreatorArrayNumbers<Integer>()).create(
                                                                new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, BOUND));

        System.out.println("Array : " + array);

        System.out.println("Result : ");
        printExpressionWithNumbersSatisfyingCondition(array);

    }

    private static void printExpressionWithNumbersSatisfyingCondition(Array<Integer> array) {
        try {
            if (checkArrayNonNull(array) && checkLengthOfArrayIsGreaterZero(array.getLength())) {
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
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }

}