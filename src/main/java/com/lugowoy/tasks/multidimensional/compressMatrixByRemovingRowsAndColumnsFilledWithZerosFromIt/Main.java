package com.lugowoy.tasks.multidimensional.compressMatrixByRemovingRowsAndColumnsFilledWithZerosFromIt;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomInteger;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;
import com.lugowoy.helper.other.MatrixAttributes;

import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_COLUMN;
import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_ROW;

/**
 * Compact the matrix by removing rows and columns filled with zeros from it.
 * <p>
 * Created by Konstantin Lugowoy on 01.11.2018.
 */

public class Main {

    private static final int UPPER_BOUND = 1;

    public static void main(String[] args) {

        MatrixAttributes matrixAttributes = new MatrixAttributes();
        matrixAttributes.setMatrixAttributes(new ReadingConsole(), System.out, MSG_ENTER_CONSOLE_ROW, MSG_ENTER_CONSOLE_COLUMN);

        Matrix<Integer> matrix = new Matrix<>(new FillingMatrixRandomInteger().fill(matrixAttributes.getRows(),
                                                                                    matrixAttributes.getColumns(),
                                                                                    UPPER_BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        compressMatrix(matrix);

        System.out.println("Result matrix : ");
        System.out.println(matrix);

    }

    private static void compressMatrix(Matrix<Integer> matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            int indexRowZeros = getIndexRowFilledZeros(matrix, i);
            if (indexRowZeros != -1) {
                matrix.compressRow(indexRowZeros);
                --i;
            }
        }
        for (int i = 0; i < matrix.getColumns(); i++) {
            int indexColumnZeros = getIndexColumnFilledZeros(matrix, i);
            if (indexColumnZeros != -1) {
                matrix.compressColumn(indexColumnZeros);
                --i;
            }
        }
    }

    private static int getIndexRowFilledZeros(Matrix<Integer> matrix, int indexRow) {
        int resultIndexRow = -1;
        int counterZeros = 0;
        for (int i = 0; i < matrix.getColumns(); i++) {
            if (matrix.getElement(indexRow, i) == 0) {
                counterZeros++;
            } else {
                break;
            }
        }
        if (counterZeros == matrix.getColumns()) {
            resultIndexRow = indexRow;
        }
        return resultIndexRow;
    }

    private static int getIndexColumnFilledZeros(Matrix<Integer> matrix, int indexColumn) {
        int resultIndexColumn = -1;
        int counterZeros = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            if (matrix.getElement(i, indexColumn) == 0) {
                counterZeros++;
            } else {
                break;
            }
        }
        if (counterZeros == matrix.getRows()) {
            resultIndexColumn = indexColumn;
        }
        return resultIndexColumn;
    }

}
