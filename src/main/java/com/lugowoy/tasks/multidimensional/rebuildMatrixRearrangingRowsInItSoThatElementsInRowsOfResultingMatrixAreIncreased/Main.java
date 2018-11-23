package com.lugowoy.tasks.multidimensional.rebuildMatrixRearrangingRowsInItSoThatElementsInRowsOfResultingMatrixAreIncreased;

import com.lugowoy.helper.filling.matrixes.numbers.FillingMatrixRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;

/**
 * Created by Konstantin Lugowoy on 23.11.2018.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());
    private static final int BOUND = 100;

    public static void main(String[] args) {

        System.out.println("Enter the number of rows for the matrix : ");
        int rows = READER.readInt();

        System.out.println("Enter the number of columns for the matrix : ");
        int columns = READER.readInt();

        Matrix<Integer> matrix = Matrix.create(new FillingMatrixRandomIntegerNumbers().fill(rows, columns, BOUND));

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
