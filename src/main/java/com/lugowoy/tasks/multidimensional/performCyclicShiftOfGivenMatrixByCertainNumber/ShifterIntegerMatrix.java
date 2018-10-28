package com.lugowoy.tasks.multidimensional.performCyclicShiftOfGivenMatrixByCertainNumber;

import com.lugowoy.helper.models.Matrix;

/**
 * Created by Konstantin Lugowoy on 28.10.2018.
 */

public class ShifterIntegerMatrix {

    static void shiftMatrixToRight(Matrix<Integer> matrix, int numberToShiftMatrix) {
        Integer[][] integers = matrix.getMatrix(new Integer[matrix.getRows()][matrix.getColumns()]);
        int k;
        for (int i = 0; i < numberToShiftMatrix; i++) {
            for (int j = 0; j < integers.length; j++) {
                int tmpBuffer = integers[j][integers.length - 1];
                for (k = integers.length - 1; k > 0; k--) {
                    integers[j][k] = integers[j][k - 1];
                }
                integers[j][k] = tmpBuffer;
            }
        }
        matrix.setMatrix(integers);
    }

    static void shiftMatrixToLeft(Matrix<Integer> matrix, int numberToShiftMatrix) {
        Integer[][] integers = matrix.getMatrix(new Integer[matrix.getRows()][matrix.getColumns()]);
        int k;
        for (int i = 0; i < numberToShiftMatrix; i++) {
            for (int j = 0; j < integers.length; j++) {
                int tmpBuffer = integers[j][0];
                for (k = 0; k < integers.length - 1; k++) {
                    integers[j][k] = integers[j][k + 1];
                }
                integers[j][k] = tmpBuffer;
            }
        }
        matrix.setMatrix(integers);
    }

    static void shiftMatrixToUp(Matrix<Integer> matrix, int numberToShiftMatrix) {
        Integer[][] integers = matrix.getMatrix(new Integer[matrix.getRows()][matrix.getColumns()]);
        int k;
        for (int i = 0; i < numberToShiftMatrix; i++) {
            for (int j = 0; j < integers.length; j++) {
                int tmpBuffer = integers[0][j];
                for (k = 0; k < integers.length - 1; k++) {
                    integers[k][j] = integers[k + 1][j];
                }
                integers[k][j] = tmpBuffer;
            }
        }
        matrix.setMatrix(integers);
    }

    static void shiftMatrixToDown(Matrix<Integer> matrix, int numberToShiftMatrix) {
        Integer[][] integers = matrix.getMatrix(new Integer[matrix.getRows()][matrix.getColumns()]);
        int k;
        for (int i = 0; i < numberToShiftMatrix; i++) {
            for (int j = 0; j < integers.length; j++) {
                int tmpBuffer = integers[integers.length - 1][j];
                for (k = integers.length - 1; k > 0; k--) {
                    integers[k][j] = integers[k - 1][j];
                }
                integers[k][j] = tmpBuffer;
            }
        }
        matrix.setMatrix(integers);
    }

}
