package com.lugowoy.tasks.onedimensional.determineIndexOfPrimeNumbersInArray;

/** Created by Konstantin Lugowoy on 22.05.2017. */

@FunctionalInterface
public interface Determinant<T extends Number> {

    boolean determine(T number);

    static boolean determineTheIndexOfPrimesInAnArray(int number) {
        boolean isPrimeNumber = true;
        if (number != 0) {
            if (number == 1) {
                isPrimeNumber = false;
            }
            for (int i = 2; i * i <= number; i++) {
                if (number % i == 0) {
                    isPrimeNumber = false;
                }
            }
        } else {
            isPrimeNumber = false;
        }
        return isPrimeNumber;
    }

}
