package com.lugowoy.tasks.onedimensional.createArrayOfZeroElementsOfAnotherArray;

import com.lugowoy.helper.models.arrays.Array;

/**Created by Konstantin Lugowoy on 12-Feb-17.*/

@FunctionalInterface
public interface FillingArray<T> {

    Array<T> fillArray(Array<T> array);

}
