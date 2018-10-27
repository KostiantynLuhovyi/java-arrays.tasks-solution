package com.lugowoy.tasks.multidimensional.sortColumnsOfMatrixInDescendingOrderOfValuesOfElementsOfKthRow;

import com.lugowoy.helper.filling.matrixes.numbers.FillingMatrixRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;

/**
 * Created by Konstantin Lugowoy on 27.10.2018.
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

        int indexColumnToSort = enterIndexColumnToSort(columns);

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        sortColumnsOfMatrixInDescendingOrderOfValuesOfElementsOfKthRow(matrix, indexColumnToSort);

        System.out.println("Result : ");
        System.out.println(matrix);

    }

    private static void sortColumnsOfMatrixInDescendingOrderOfValuesOfElementsOfKthRow(Matrix<Integer> matrix, int indexColumnToSort) {
        Integer[][] ints = matrix.getMatrix(new Integer[matrix.getRows()][matrix.getColumns()]);
        for(int i = 0; i < ints.length; i++){
            for(int j = 0; j < ints[i].length - 1; j++){
                if(ints[indexColumnToSort][j + 1] > ints[indexColumnToSort][j]){
                    for(int k = 0; k < ints[i].length; k++){
                        int tmp = ints[k][j];
                        ints[k][j] = ints[k][j + 1];
                        ints[k][j + 1] = tmp;
                    }
                }
            }
        }
        matrix.setMatrix(ints);
    }

    private static int enterIndexColumnToSort(int rows) {
        int resultIndexRow;
        System.out.println("Enter the column number to sort : ");
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
