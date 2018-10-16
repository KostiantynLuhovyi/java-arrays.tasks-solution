package com.lugowoy.tasks.onedimensional.createArrayOfZeroElementsOfAnotherArray;

import com.lugowoy.helper.models.Array;

/**Created by Konstantin Lugowoy on 12-Feb-17.*/

@FunctionalInterface
public interface Filling {

    Array<Integer> fillArray(Array<Integer> array);

}
