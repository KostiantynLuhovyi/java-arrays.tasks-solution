package com.lugowoy.tasks.multidimensional.buildMatrixSubtractingFromElementsOfEachRowOfMatrixItsArithmeticAverage;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomDouble;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;
import com.lugowoy.helper.other.MatrixAttributes;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_DOUBLE_BOUND;
import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_COLUMN;
import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_ROW;

/**
 * Build a matrix, subtracting from the elements of each row of the matrix its arithmetic average.
 * <p>
 * Created by LugowoyKonstantin on 30.10.2018.
 */

public class Main {

    public static void main(String[] args) {

        MatrixAttributes matrixAttributes = new MatrixAttributes();
        matrixAttributes.setMatrixAttributes(new ReadingConsole(), System.out, MSG_ENTER_CONSOLE_ROW, MSG_ENTER_CONSOLE_COLUMN);

        Matrix<Double> matrix = new Matrix<>(new FillingMatrixRandomDouble().fill(matrixAttributes.getRows(),
                                                                                  matrixAttributes.getColumns(),
                                                                                  POSITIVE_DOUBLE_BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        subtractArithmeticAverageValueFromElementsOfMatrix(matrix);

        System.out.println("Result matrix : ");
        System.out.println(matrix);

    }

    private static void subtractArithmeticAverageValueFromElementsOfMatrix(Matrix<Double> matrix) {
        double resultArithmeticAverage = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                resultArithmeticAverage += matrix.getElement(i, j);
            }
            resultArithmeticAverage /= matrix.getColumns();
            for (int j = 0; j < matrix.getColumns(); j++) {
                matrix.setElement(i, j, new BigDecimal(matrix.getElement(i, j) - resultArithmeticAverage).setScale(2, RoundingMode.HALF_DOWN).doubleValue());
            }
            resultArithmeticAverage = 0;
        }
    }

}
