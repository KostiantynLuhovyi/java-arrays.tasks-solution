package com.lugowoy.tasks.multidimensional.sortRowsOfMatrixInDescendingOrderOfValuesOfElementsOfKthColumn;

import com.lugowoy.helper.filling.matrixes.numbers.FillingMatrixRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;

/**
 * Created by Konstantin Lugowoy on 26.10.2018.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    private static final int BOUND = 20;

    public static void main(String[] args) {

        System.out.println("Enter number of rows in the matrix : ");
        int rows = READER.readInt();

        System.out.println("Enter number of columns in the matrix : ");
        int columns = READER.readInt();

        Matrix<Integer> matrix = Matrix.create(new FillingMatrixRandomIntegerNumbers().fill(rows, columns, BOUND));

        int indexRowToSort = enterIndexRowToSort(rows);

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        sortRowsOfMatrixInDescendingOrderOfValuesOfElementsOfKthColumn(matrix, indexRowToSort);

        System.out.println("Result : ");
        System.out.println(matrix);

    }

    private static void sortRowsOfMatrixInDescendingOrderOfValuesOfElementsOfKthColumn(Matrix<Integer> matrix, int indexRowToSort) {
        Integer[][] ints = matrix.getMatrix(new Integer[matrix.getRows()][matrix.getColumns()]);
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[i][indexRowToSort] < ints[j][indexRowToSort]) {
                    for (int k = 0; k < ints.length; k++) {
                        int temp = ints[i][k];
                        ints[i][k] = ints[j][k];
                        ints[j][k] = temp;
                    }
                }
            }
        }
        matrix.setMatrix(ints);
    }

    private static int enterIndexRowToSort(int rows) {
        int resultIndexRow;
        System.out.println("Enter the row number to sort : ");
        while (true) {
            resultIndexRow = READER.readInt();
            if (resultIndexRow >= 0 && resultIndexRow <= rows) {
                break;
            } else {
                System.out.println("Incorrect number. Re-enter : ");
            }
        }
        return resultIndexRow;
    }

}
