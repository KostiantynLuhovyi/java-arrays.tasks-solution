package com.lugowoy.tasks.multidimensional.transposeSquareMatrix;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomInteger;
import com.lugowoy.helper.models.Matrix;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;
import static com.lugowoy.helper.models.Matrix.DEFAULT_COLUMNS;
import static com.lugowoy.helper.models.Matrix.DEFAULT_ROWS;

/**
 * Transpose square matrix.
 * <p>
 * Created by Konstantin Lugowoy on 29.10.2018.
 */

public class Main {

    public static void main(String[] args) {

        Matrix<Integer> matrix = new Matrix<>(new FillingMatrixRandomInteger().fill(DEFAULT_ROWS, DEFAULT_COLUMNS,
                                                                                    POSITIVE_INTEGER_BOUND));

        System.out.println("Matrix : ");
        System.out.println(matrix);

        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = i + 1; j < matrix.getColumns(); j++) {
                int tmp = matrix.getElement(i, j);
                matrix.setElement(i, j, matrix.getElement(j, i));
                matrix.setElement(j, i, tmp);
            }
        }

        System.out.println("Transpose matrix : ");
        System.out.println(matrix);

    }

}
