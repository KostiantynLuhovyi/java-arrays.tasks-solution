package com.lugowoy.tasks.multidimensional.performCyclicShiftOfGivenMatrixByCertainNumber;

import com.lugowoy.helper.models.Matrix;

/**
 * Created by Konstantin Lugowoy on 28.10.2018.
 */

@FunctionalInterface
public interface Shifter<T> {

    void shift(Matrix<T> matrix, int numberToShiftMatrix);

}
