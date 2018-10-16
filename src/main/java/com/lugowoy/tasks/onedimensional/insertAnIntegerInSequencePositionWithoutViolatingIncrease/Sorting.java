package com.lugowoy.tasks.onedimensional.insertAnIntegerInSequencePositionWithoutViolatingIncrease;

import com.lugowoy.helper.models.Array;

import java.util.Arrays;
import java.util.stream.Collectors;

/** Created by Konstantin Lugowoy on 11.03.2017. */

public interface Sorting<T> {

    void sort(Array<T> array);

    static void sortingIntegerSequence(Array<Integer> array) {
        Arrays.stream(array.toArray()).sorted().collect(Collectors.toList()).toArray(array.toArray());
    }

}
