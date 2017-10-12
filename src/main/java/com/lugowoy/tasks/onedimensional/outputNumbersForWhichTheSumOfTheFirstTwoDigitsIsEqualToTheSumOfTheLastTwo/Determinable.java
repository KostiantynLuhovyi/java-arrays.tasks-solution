package com.lugowoy.tasks.onedimensional.outputNumbersForWhichTheSumOfTheFirstTwoDigitsIsEqualToTheSumOfTheLastTwo;

/** Created by Konstantin Lugowoy on 30.05.2017. */

@FunctionalInterface
public interface Determinable {

    boolean determine(int number);

    static boolean determineNumbersForWhichTheSumOfTheFirstTwoDigitsIsEqualToTheSumOfTheLastTwo(int number) {
        boolean result = false;

        String stringNumber = Integer.toString(number);
        if (stringNumber.length() == 4) {
            //right part of number
            int rightPartOfNumber = number % 10;
            number /= 10;
            rightPartOfNumber = rightPartOfNumber + number % 10;
            number /= 10;
            //left part of number
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
