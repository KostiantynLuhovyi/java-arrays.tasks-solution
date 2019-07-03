package com.lugowoy.tasks.multidimensional.roundAllElementsOfMatrixToInteger;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomDouble;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;
import com.lugowoy.helper.other.MatrixAttributes;

import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_COLUMN;
import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_ROW;

/**
 * Round all elements of the matrix to an integer.
 * <p>
 * Created by Konstantin Lugowoy on 07.11.2018.
 */

public class Main {

    private static final double UPPER_BOUND = 20.0;

    public static void main(String[] args) {

        MatrixAttributes matrixAttributes = new MatrixAttributes();
        matrixAttributes.setMatrixAttributes(new ReadingConsole(), System.out, MSG_ENTER_CONSOLE_ROW, MSG_ENTER_CONSOLE_COLUMN);

        Matrix<Double> matrix = new Matrix<>(new FillingMatrixRandomDouble().fill(matrixAttributes.getRows(),
                                                                                  matrixAttributes.getColumns(),
                                                                                  UPPER_BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        Matrix<Integer> integerMatrix = new Matrix<>(matrix.getRows(), matrix.getColumns());
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                integerMatrix.setElement(i, j, (int) Math.round(matrix.getElement(i, j)));
            }
        }

        System.out.println("Result matrix : ");
        System.out.println(integerMatrix);

    }

}
