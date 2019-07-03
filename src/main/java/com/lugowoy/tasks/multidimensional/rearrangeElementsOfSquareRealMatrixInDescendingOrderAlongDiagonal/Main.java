package com.lugowoy.tasks.multidimensional.rearrangeElementsOfSquareRealMatrixInDescendingOrderAlongDiagonal;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomDouble;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;
import com.lugowoy.helper.other.MatrixAttributes;

import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_COLUMN;
import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_ROW;

/**
 * Rearrange the elements of a square real matrix in descending order along the diagonal.
 * <p>
 * Created by Konstantin Lugowoy on 28.11.2018.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());
    private static final double UPPER_BOUND = 10;

    public static void main(String[] args) {

        MatrixAttributes matrixAttributes = new MatrixAttributes();
        matrixAttributes.setMatrixAttributes(new ReadingConsole(), System.out, MSG_ENTER_CONSOLE_ROW, MSG_ENTER_CONSOLE_COLUMN);

        Matrix<Double> matrix = new Matrix<>(new FillingMatrixRandomDouble().fill(matrixAttributes.getRows(),
                                                                                  matrixAttributes.getColumns(),
                                                                                  UPPER_BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        rearrangeElementsOfMatrixInDescendingOrderAlongDiagonal(matrix);

        System.out.println("Result matrix : ");
        System.out.println(matrix);

    }

    private static void rearrangeElementsOfMatrixInDescendingOrderAlongDiagonal(Matrix<Double> matrix) {
        int length = matrix.getRows();
        for (int n = 0; n < length; n++) {
            int row = 0, col = 0;
            double maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < matrix.getRows(); i++) {
                for (int j = 0; j < matrix.getColumns(); j++) {
                    double element = matrix.getElement(i, j);
                    if (i != j || i > n) {
                        if (element > maxValue) {
                            maxValue = element;
                            row = i;
                            col = j;
                        }
                    }
                }
                double tmp = matrix.getElement(n, n);
                matrix.setElement(n, n, matrix.getElement(row, col));
                matrix.setElement(row, col, tmp);
            }
        }
    }

}