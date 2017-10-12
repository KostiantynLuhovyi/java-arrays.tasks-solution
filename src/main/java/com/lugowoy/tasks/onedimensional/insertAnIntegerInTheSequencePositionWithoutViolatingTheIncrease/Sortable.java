package com.lugowoy.tasks.onedimensional.insertAnIntegerInTheSequencePositionWithoutViolatingTheIncrease;

import java.util.Arrays;
import java.util.stream.Collectors;

/** Created by Konstantin Lugowoy on 11.03.2017. */

public interface Sortable<T> {

    void sort(T[] tArray);

    static void sortingIntegerSequence(Integer[] integers) {
        Arrays.stream(integers).sorted().collect(Collectors.toList()).toArray(integers);
    }

}
