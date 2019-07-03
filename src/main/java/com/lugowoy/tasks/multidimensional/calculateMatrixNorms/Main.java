package com.lugowoy.tasks.multidimensional.calculateMatrixNorms;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomDouble;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;
import com.lugowoy.helper.other.MatrixAttributes;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.NEGATIVE_DOUBLE_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_DOUBLE_BOUND;
import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_COLUMN;
import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_ROW;

/**
 * Calculate the matrix norms.
 * <p>
 * Created by Konstantin Lugowoy on 30.10.2018.
 */

public class Main {

    public static void main(String[] args) {

        MatrixAttributes matrixAttributes = new MatrixAttributes();
        matrixAttributes.setMatrixAttributes(new ReadingConsole(), System.out, MSG_ENTER_CONSOLE_ROW, MSG_ENTER_CONSOLE_COLUMN);

        Matrix<Double> matrix = new Matrix<>(new FillingMatrixRandomDouble().fill(matrixAttributes.getRows(),
                                                                                  matrixAttributes.getColumns(),
                                                                                  NEGATIVE_DOUBLE_BOUND,
                                                                                  POSITIVE_DOUBLE_BOUND));

        System.out.println("Matrix : ");
        System.out.println(matrix);

        CalculatorMatrixNorms calculatorMatrixNorms = CalculatorMatrixNorms::calculateMatrixColumnsNorm;
        double normMatrixRows = calculatorMatrixNorms.calculateMatrixNorm(matrix);

        calculatorMatrixNorms = CalculatorMatrixNorms::calculateMatrixRowsNorm;
        double normMatrixColumns = calculatorMatrixNorms.calculateMatrixNorm(matrix);

        System.out.printf("Norm of rows : %.3f", normMatrixRows);
        System.out.println();
        System.out.printf("Norm of columns : %.3f", normMatrixColumns);

    }

}
