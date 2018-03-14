package com.lugowoy.tasks.onedimensional.compressArrayByThrowingOutNullElements;

import com.lugowoy.helper.models.arrays.Array;

/** Created by Konstantin Lugowoy on 16.03.2017. */

@FunctionalInterface
public interface Compressing<T> {

    void compress(Array<T> array);

}
