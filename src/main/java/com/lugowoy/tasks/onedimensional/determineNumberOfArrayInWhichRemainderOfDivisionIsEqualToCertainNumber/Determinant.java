package com.lugowoy.tasks.onedimensional.determineNumberOfArrayInWhichRemainderOfDivisionIsEqualToCertainNumber;

/**Created by Konstantin Lugowoy on 14-Feb-17.*/

@FunctionalInterface
public interface Determinant {

    void determinate(int[] numbers, int numberToModulo, int resultModulo);

}
