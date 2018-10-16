package com.lugowoy.tasks.onedimensional.compressArrayByThrowingOutZeroValueElements;

import com.lugowoy.helper.models.Array;

/** Created by Konstantin Lugowoy on 16.03.2017. */

@FunctionalInterface
public interface Compressing<T> {

    void compress(Array<T> array);

}
