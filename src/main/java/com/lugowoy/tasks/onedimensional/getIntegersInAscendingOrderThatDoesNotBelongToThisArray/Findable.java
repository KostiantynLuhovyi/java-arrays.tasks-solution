package com.lugowoy.tasks.onedimensional.getIntegersInAscendingOrderThatDoesNotBelongToThisArray;

import com.lugowoy.helper.models.arrays.Array;

import java.util.Arrays;
import java.util.Collections;

/** Created by Konstantin Lugowoy on 11.04.2017. */

public interface Findable<T, V> {

    T find(V v);

    static int findMaxNumber(Array<Integer> array) {
        return Collections.max(Arrays.asList(array.getArray()));
    }

    static int findMinNumber(Array<Integer> array) {
        return Collections.min(Arrays.asList(array.getArray()));
    }

}
