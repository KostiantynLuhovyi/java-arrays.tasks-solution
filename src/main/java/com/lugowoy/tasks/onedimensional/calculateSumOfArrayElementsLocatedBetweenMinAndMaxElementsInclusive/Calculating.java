package com.lugowoy.tasks.onedimensional.calculateSumOfArrayElementsLocatedBetweenMinAndMaxElementsInclusive;

import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.other.ArrayChecker.checkArrayNonNull;
import static com.lugowoy.helper.other.ArrayChecker.checkLengthOfArrayIsEqualToOrGreaterThanZero;

/** Created by Konstantin Lugowoy on 27.03.2017. */

@FunctionalInterface
public interface Calculating {

    int calculate(Array<Integer> array, int indexMinElement, int indexMaxElement);

}
