package com.lugowoy.tasks.onedimensional.determineNumberOfArrayInWhichRemainderOfDivisionIsEqualToCertainNumber;

import com.lugowoy.helper.models.Array;

/**Created by Konstantin Lugowoy on 14-Feb-17.*/

@FunctionalInterface
public interface Determinant {

    void determinate(Array<Integer> array, int numberToModulo, int resultModulo);

}
