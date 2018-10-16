package com.lugowoy.tasks.onedimensional.findSumOfArrayOfMultipleElementsToThisPresent;

import com.lugowoy.helper.models.Array;

/**Created by Konstantin Lugowoy on 12-Feb-17.*/

@FunctionalInterface
public interface Finding {

    int calculateSumOfElements(Array<Integer> array, int k);

}
