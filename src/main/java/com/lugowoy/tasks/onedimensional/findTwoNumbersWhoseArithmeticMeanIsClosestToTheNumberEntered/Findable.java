package com.lugowoy.tasks.onedimensional.findTwoNumbersWhoseArithmeticMeanIsClosestToTheNumberEntered;

import com.lugowoy.helper.models.arrays.Array;

/** Created by Konstantin Lugowoy on 12.04.2017. */

public interface Findable<T, V> {

    void find(T t, V v);

    static void findTwoNumbersWhoseArithmeticMeanIsClosestToTheNumber(double numberEntered, Array<Double> array) {
        if (array.getArray().length > 1) {
            double diff = (array.getArray()[0] + array.getArray()[1]) / 2 - numberEntered;
            double firstNumber = array.getArray()[0];
            double secondNumber = array.getArray()[1];
            double temp;
            for (int i = 0; i < array.getArray().length; i++) {
                for (int j = i + 1; j < array.getArray().length; j++) {
                    temp = (array.getArray()[i] + array.getArray()[j]) / 2 - numberEntered;
                    if (Math.abs(temp) < Math.abs(diff)) {
                        diff = temp;
                        firstNumber = array.getArray()[i];
                        secondNumber = array.getArray()[j];
                    }
                }
            }
            System.out.println();
            System.out.println("Result numbers : " + firstNumber + " and " + secondNumber + " .");
        }
    }

}
