package com.lugowoy.tasks.multidimensional.rebuildMatrixRearrangingRowsInItSoThatElementsInRowsOfResultingMatrixAreIncreased;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomInteger;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;
import com.lugowoy.helper.other.MatrixAttributes;

import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_COLUMN;
import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_ROW;

/**
 * Rebuild the matrix, rearranging the rows in it so that the elements in the rows of the resulting matrix are increased.
 * <p>
 * Created by Konstantin Lugowoy on 23.11.2018.
 */

public class Main {

    private static final int UPPER_BOUND = 100;

    public static void main(String[] args) {

        MatrixAttributes matrixAttributes = new MatrixAttributes();
        matrixAttributes.setMatrixAttributes(new ReadingConsole(), System.out, MSG_ENTER_CONSOLE_ROW, MSG_ENTER_CONSOLE_COLUMN);

        Matrix<Integer> matrix = new Matrix<>(new FillingMatrixRandomInteger().fill(matrixAttributes.getRows(),
                                                                                    matrixAttributes.getColumns(),
                                                                                    UPPER_BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        rebuildMatrix(matrix);

        System.out.println("Result of rebuilding the matrix : ");
        System.out.println(matrix);

    }

    private static void swap(Integer[][] matrixSort, int indexColumn) {
        Integer[] tmp = matrixSort[indexColumn];
        matrixSort[indexColumn] = matrixSort[indexColumn + 1];
        matrixSort[indexColumn + 1] = tmp;
    }

    private static void rebuildMatrix(Matrix<Integer> matrix) {
        Integer[][] matrixSort = matrix.getMatrix(new Integer[matrix.getRows()][matrix.getColumns()]);
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns() - i - 1; j++) {
                if (sumLine(matrixSort, j) > sumLine(matrixSort, j + 1)) {
                    swap(matrixSort, j);
                }
            }
        }
        matrix.setMatrix(matrixSort);
    }

    private static int sumLine(Integer[][] matrix, int indexRow) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            result = result + matrix[indexRow][i];
        }
        return result;
    }

}
