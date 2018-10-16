package com.lugowoy.tasks.onedimensional.calculateSumOfArrayElementsLocatedBetweenMinAndMaxElementsInclusive;

import com.lugowoy.helper.models.Array;

/** Created by Konstantin Lugowoy on 27.03.2017. */

@FunctionalInterface
public interface Calculating {

    int calculate(Array<Integer> array, int indexMinElement, int indexMaxElement);

}
