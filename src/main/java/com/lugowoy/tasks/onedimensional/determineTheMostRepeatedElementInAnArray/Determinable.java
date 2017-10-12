package com.lugowoy.tasks.onedimensional.determineTheMostRepeatedElementInAnArray;

import com.lugowoy.helper.models.arrays.Array;

/** Created by Konstantin Lugowoy on 22.03.2017. */

@FunctionalInterface
public interface Determinable<T> {

    void determine(Array<T> array);

}
