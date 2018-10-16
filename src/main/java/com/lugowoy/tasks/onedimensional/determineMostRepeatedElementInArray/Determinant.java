package com.lugowoy.tasks.onedimensional.determineMostRepeatedElementInArray;

import com.lugowoy.helper.models.Array;

/** Created by Konstantin Lugowoy on 22.03.2017. */

@FunctionalInterface
public interface Determinant<T> {

    void determine(Array<T> array);

}
