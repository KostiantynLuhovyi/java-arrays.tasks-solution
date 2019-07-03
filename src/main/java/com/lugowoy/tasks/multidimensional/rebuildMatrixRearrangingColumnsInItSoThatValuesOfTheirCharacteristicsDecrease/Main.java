package com.lugowoy.tasks.multidimensional.rebuildMatrixRearrangingColumnsInItSoThatValuesOfTheirCharacteristicsDecrease;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomInteger;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;
import com.lugowoy.helper.other.MatrixAttributes;

import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_COLUMN;
import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_ROW;

/**
 * Rebuild the given matrix, rearranging the columns in it so that the values of their characteristics decrease.
 * <p>
 * Created by Konstantin Lugowoy on 26.11.2018.
 */

public class Main {

    private static final int LOWER_BOUND = -10;
    private static final int UPPER_BOUND = 10;

    public static void main(String[] args) {

        MatrixAttributes matrixAttributes = new MatrixAttributes();
        matrixAttributes.setMatrixAttributes(new ReadingConsole(), System.out, MSG_ENTER_CONSOLE_ROW, MSG_ENTER_CONSOLE_COLUMN);

        Matrix<Integer> matrix = new Matrix<>(new FillingMatrixRandomInteger().fill(matrixAttributes.getRows(),
                                                                                    matrixAttributes.getColumns(),
                                                                                    LOWER_BOUND, UPPER_BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        rebuildMatrixBySortingColumnDescendingCharacteristics(matrix);

        System.out.println("Result matrix : ");
        System.out.println(matrix);

    }

    private static void rebuildMatrixBySortingColumnDescendingCharacteristics(Matrix<Integer> matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns() - i - 1; j++) {
                if (calculateSumColumnElement(matrix, j) > calculateSumColumnElement(matrix, j + 1)) {
                    Integer[] tmp = matrix.getColumn(new Integer[matrix.getColumns()], j);
                    matrix.setColumn(matrix.getColumn(new Integer[matrix.getColumns()], j + 1), j);
                    matrix.setColumn(tmp, j + 1);
                }
            }
        }
    }

    private static int calculateSumColumnElement(Matrix<Integer> matrix, int indexColumn) {
        int result = 0;
        for (int i = 0; i < matrix.getColumns(); i++) {
            result = result + Math.abs(matrix.getElement(i, indexColumn));
        }
        return result;
    }

}
