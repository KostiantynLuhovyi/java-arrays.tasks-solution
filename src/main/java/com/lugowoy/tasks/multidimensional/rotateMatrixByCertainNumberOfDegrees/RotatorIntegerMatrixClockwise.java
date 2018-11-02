package com.lugowoy.tasks.multidimensional.rotateMatrixByCertainNumberOfDegrees;

import com.lugowoy.helper.models.Matrix;

/**
 * Created by Konstantin Lugowoy on 30.10.2018.
 */

public interface RotatorIntegerMatrixClockwise {

    static void rotateMatrixTo90Degrees(Matrix<Integer> matrix) {
        Integer[][] tmpMatrix = new Integer[matrix.getRows()][matrix.getColumns()];
        for (int i = 0; i < matrix.getRows(); i++)
            for (int j = 0; j < matrix.getColumns(); j++) {
                tmpMatrix[matrix.getColumns() - 1 - j][i] = matrix.getElement(i, j);
            }
        matrix.setMatrix(tmpMatrix);
    }

    static void rotateMatrixTo180Degrees(Matrix<Integer> matrix) {
        rotateMatrixTo90Degrees(matrix);
        rotateMatrixTo90Degrees(matrix);
    }

    static void rotateMatrixTo270Degrees(Matrix<Integer> matrix) {
        rotateMatrixTo180Degrees(matrix);
        rotateMatrixTo90Degrees(matrix);
    }

    static void rotateMatrixTo360Degress(Matrix<Integer> matrix) {
        rotateMatrixTo270Degrees(matrix);
        rotateMatrixTo90Degrees(matrix);
    }

}
