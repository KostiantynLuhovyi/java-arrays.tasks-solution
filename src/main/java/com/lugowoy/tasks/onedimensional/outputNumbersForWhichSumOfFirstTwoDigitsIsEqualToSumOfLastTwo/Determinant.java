package com.lugowoy.tasks.onedimensional.outputNumbersForWhichSumOfFirstTwoDigitsIsEqualToSumOfLastTwo;

/** Created by Konstantin Lugowoy on 30.05.2017. */

@FunctionalInterface
public interface Determinant {

    boolean determine(int number);

    static boolean determineNumbersForWhichTheSumOfTheFirstTwoDigitsIsEqualToTheSumOfTheLastTwo(int number) {
        boolean result = false;

        String stringNumber = Integer.toString(number);
        if (stringNumber.length() == 4) {

            int rightPartOfNumber = number % 10;
            number /= 10;
            rightPartOfNumber = rightPartOfNumber + number % 10;
            number /= 10;

            int leftPartOfNumber = number % 10;
            number /= 10;
            leftPartOfNumber += number;

            if (rightPartOfNumber == leftPartOfNumber) {
                result = true;
            }
        }
        return result;
    }

}
