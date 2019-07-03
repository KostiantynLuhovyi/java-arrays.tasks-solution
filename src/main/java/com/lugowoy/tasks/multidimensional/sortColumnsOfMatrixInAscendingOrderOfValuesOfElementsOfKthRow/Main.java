package com.lugowoy.tasks.multidimensional.sortColumnsOfMatrixInAscendingOrderOfValuesOfElementsOfKthRow;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomInteger;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;
import com.lugowoy.helper.other.MatrixAttributes;

import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_COLUMN;
import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_ROW;

/**
 * Sort the columns in ascending order of values of the elements of k-th row.
 * <p>
 * Created by Konstantin Lugowoy on 27.10.2018.
 */

public class Main {

    private static final int UPPER_BOUND = 20;

    public static void main(String[] args) {

        MatrixAttributes matrixAttributes = new MatrixAttributes();
        matrixAttributes.setMatrixAttributes(new ReadingConsole(), System.out, MSG_ENTER_CONSOLE_ROW, MSG_ENTER_CONSOLE_COLUMN);

        Matrix<Integer> matrix = new Matrix<>(new FillingMatrixRandomInteger().fill(matrixAttributes.getRows(),
                                                                                    matrixAttributes.getColumns(),
                                                                                    UPPER_BOUND));

        int indexColumnToSort = enterIndexColumnToSort(matrix.getColumns());

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        sortColumnsOfMatrixInAscendingOrderOfValuesOfElementsOfKthRow(matrix, indexColumnToSort);

        System.out.println("Result : ");
        System.out.println(matrix);

    }

    private static void sortColumnsOfMatrixInAscendingOrderOfValuesOfElementsOfKthRow(Matrix<Integer> matrix, int indexColumnToSort) {
        Integer[][] ints = matrix.getMatrix(new Integer[matrix.getRows()][matrix.getColumns()]);
        for(int i = 0; i < ints.length; i++){
            for(int j = 0; j < ints[i].length - 1; j++){
                if(ints[indexColumnToSort][j + 1] < ints[indexColumnToSort][j]){
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
        Reader reader = Reader.getReader(new ReadingConsole());
        while (true) {
            resultIndexRow = reader.readInt();
            if (resultIndexRow >= 0 && resultIndexRow <= rows) {
                break;
            } else {
                System.out.println("Incorrect number. Re-enter : ");
            }
        }
        return resultIndexRow;
    }

}
