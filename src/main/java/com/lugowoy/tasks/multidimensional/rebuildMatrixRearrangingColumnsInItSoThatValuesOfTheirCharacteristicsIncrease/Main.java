package com.lugowoy.tasks.multidimensional.rebuildMatrixRearrangingColumnsInItSoThatValuesOfTheirCharacteristicsIncrease;

import com.lugowoy.helper.filling.matrixes.numbers.FillingMatrixRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;

/**
 * Created by Konstantin Lugowoy on 27.11.2018.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    private static final int START_BOUND = -10;
    private static final int END_BOUND = 10;

    public static void main(String[] args) {

        System.out.println("Enter the number of rows for the matrix : ");
        int rows = READER.readInt();

        System.out.println("Enter the number of columns for the matrix : ");
        int columns = READER.readInt();

        Matrix<Integer> matrix = Matrix.create(new FillingMatrixRandomIntegerNumbers().fill(rows, columns, START_BOUND, END_BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        rebuildMatrixBySortingColumnsAscendingCharacteristics(matrix);

        System.out.println("Result matrix : ");
        System.out.println(matrix);

    }

    private static void rebuildMatrixBySortingColumnsAscendingCharacteristics(Matrix<Integer> matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns() - i - 1; j++) {
                if (calculateSumColumnElement(matrix, j) < calculateSumColumnElement(matrix, j + 1)) {
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
