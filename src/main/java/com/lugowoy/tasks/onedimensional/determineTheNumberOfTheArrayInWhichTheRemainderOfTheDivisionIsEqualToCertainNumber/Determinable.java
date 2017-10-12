package com.lugowoy.tasks.onedimensional.determineTheNumberOfTheArrayInWhichTheRemainderOfTheDivisionIsEqualToCertainNumber;

/**Created by Konstantin Lugowoy on 14-Feb-17.*/

@FunctionalInterface
public interface Determinable {

    void determinate(int[] numbers, int numberToModulo, int resultModulo);

}
