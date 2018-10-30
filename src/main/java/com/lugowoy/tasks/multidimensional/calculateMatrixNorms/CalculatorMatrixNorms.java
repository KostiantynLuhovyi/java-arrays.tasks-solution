package com.lugowoy.tasks.multidimensional.calculateMatrixNorms;

import com.lugowoy.helper.models.Matrix;

import static java.lang.Math.*;

/**
 * Created by Konstantin Lugowoy on 30.10.2018.
 */

@FunctionalInterface
public interface CalculatorMatrixNorms {

    double calculateMatrixNorm(Matrix<Double> matrix);

    static double calculateMatrixColumnsNorm(Matrix<Double> matrix) {
        double resultNorm = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            double sum = 0;
            for (int j = 0; j < matrix.getColumns(); j++) {
                sum += abs(matrix.getElementMatrix(i, j));
            }
            resultNorm = max(resultNorm, sum);
        }
        return resultNorm;
    }

    static double calculateMatrixRowsNorm(Matrix<Double> matrix) {
        double resultNorm = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            double sum = 0;
            for (int j = 0; j < matrix.getColumns(); j++) {
                sum += abs(matrix.getElementMatrix(j, i));
            }
            resultNorm = max(resultNorm, sum);
        }
        return resultNorm;
    }

}
