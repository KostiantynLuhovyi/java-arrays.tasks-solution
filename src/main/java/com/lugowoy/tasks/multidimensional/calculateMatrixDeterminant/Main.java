package com.lugowoy.tasks.multidimensional.calculateMatrixDeterminant;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomInteger;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;
import com.lugowoy.helper.other.MatrixAttributes;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.NEGATIVE_INTEGER_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;
import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_COLUMN;
import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_ROW;
import static java.lang.Math.pow;

/**
 * Calculate the matrix determinant.
 * <p>
 * Created by Konstantin Lugowoy on 31.10.2018.
 */

public class Main {

    public static void main(String[] args) {

        MatrixAttributes matrixAttributes = new MatrixAttributes();
        matrixAttributes.setMatrixAttributes(new ReadingConsole(), System.out, MSG_ENTER_CONSOLE_ROW, MSG_ENTER_CONSOLE_COLUMN);

        Matrix<Integer> matrix = new Matrix<>(new FillingMatrixRandomInteger().fill(matrixAttributes.getRows(),
                                                                                    matrixAttributes.getColumns(),
                                                                                    NEGATIVE_INTEGER_BOUND,
                                                                                    POSITIVE_INTEGER_BOUND));

        System.out.println("Matrix : ");
        System.out.println(matrix);

        double resultMatrixDeterminant = calculateMatrixDeterminant(matrix.getMatrix(new Integer[matrix.getRows()][matrix.getColumns()]));
        System.out.println("Matrix determinant : " + resultMatrixDeterminant);

    }

    private static double calculateMatrixDeterminant(Integer[][] matrix) {
        Integer[][] tmp;
        double resultMatrixDeterminant = 0;
        if (matrix.length == 1) {
            resultMatrixDeterminant = matrix[0][0];
            return (resultMatrixDeterminant);
        }
        if (matrix.length == 2) {
            resultMatrixDeterminant = ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
            return (resultMatrixDeterminant);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            tmp = new Integer[matrix.length - 1][matrix[0].length - 1];
            for (int j = 1; j < matrix.length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    if (k < i) {
                        tmp[j - 1][k] = matrix[j][k];
                    } else if (k > i) {
                        tmp[j - 1][k - 1] = matrix[j][k];
                    }
                }
            }
            resultMatrixDeterminant += matrix[0][i] * pow(-1, (double) i) * calculateMatrixDeterminant(tmp);
        }
        return resultMatrixDeterminant;
    }

}
