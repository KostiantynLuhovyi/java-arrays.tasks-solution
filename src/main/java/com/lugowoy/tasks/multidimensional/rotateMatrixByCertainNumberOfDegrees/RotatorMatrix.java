package com.lugowoy.tasks.multidimensional.rotateMatrixByCertainNumberOfDegrees;

import com.lugowoy.helper.models.Matrix;

/**
 * Created by Konstantin Lugowoy on 30.10.2018.
 */

@FunctionalInterface
public interface RotatorMatrix<T> {

    void rotateMatrix(Matrix<T> matrix);

}
