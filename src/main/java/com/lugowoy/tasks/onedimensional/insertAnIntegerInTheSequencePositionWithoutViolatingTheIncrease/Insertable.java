package com.lugowoy.tasks.onedimensional.insertAnIntegerInTheSequencePositionWithoutViolatingTheIncrease;

import com.lugowoy.helper.models.arrays.Array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** Created by Konstantin Lugowoy on 11.03.2017. */

@FunctionalInterface
public interface Insertable<T> {

    void insert(T t, Array<T> array);

    static void insertElement(Integer integer, Array<Integer> array) {
        List<Integer> integerList;
        if ((integer != null) && (array != null)) {
            for (int i = 1; i < array.getArray().length; i++) {
                if (((integer > array.getArray()[i - 1]) || (integer.intValue() == (array.getArray()[i - 1])))
                        && ((integer < array.getArray()[i]) || (integer.intValue() == (array.getArray()[i])))) {
                    integerList = Arrays.stream(array.getArray()).collect(Collectors.toList());
                    integerList.add(i, integer);
                    array.setArray(integerList.toArray(new Integer[integerList.size()]));
                    break;
                }
            }
        }
    }

}
