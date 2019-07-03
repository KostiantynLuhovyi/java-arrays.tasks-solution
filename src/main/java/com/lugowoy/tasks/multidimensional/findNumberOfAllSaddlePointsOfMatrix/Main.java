package com.lugowoy.tasks.multidimensional.findNumberOfAllSaddlePointsOfMatrix;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomInteger;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;
import com.lugowoy.helper.other.MatrixAttributes;

import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_COLUMN;
import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_ROW;

/**
 * Find the number of all saddle points of the matrix.
 * <p>
 * Created by Konstantin Lugowoy on 07.11.2018.
 */

public class Main {

    private static final int UPPER_BOUND = 100;

    public static void main(String[] args) {

        MatrixAttributes matrixAttributes = new MatrixAttributes();
        matrixAttributes.setMatrixAttributes(new ReadingConsole(), System.out, MSG_ENTER_CONSOLE_ROW, MSG_ENTER_CONSOLE_COLUMN);

        Matrix<Integer> matrix = new Matrix<>(new FillingMatrixRandomInteger().fill(matrixAttributes.getRows(),
                                                                                    matrixAttributes.getColumns(),
                                                                                    UPPER_BOUND));

        System.out.println("Matrix : ");
        System.out.println(matrix);

        findSaddleNumbersOfMatrix(matrix);

    }

    private static void findSaddleNumbersOfMatrix(Matrix<Integer> matrix) {
        int counterResult = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                int element = matrix.getElement(i, j);
                if (isMinElementInRow(matrix, i, element) && isMaxElementInColumn(matrix, j, element)) {
                    System.out.println("Saddle value under the row index : " + i + " and column index :" + j + " equals : " + element);
                    counterResult++;
                }
            }
        }
        if (counterResult == 0) {
            System.out.println("Matrix does not contain saddle values.");
        }
    }

    private static boolean isMinElementInRow(Matrix<Integer> matrix, int indexRow, int valueToEqual) {
        boolean result = true;
        for (int i = 0; i < matrix.getColumns(); i++) {
            int element = matrix.getElement(indexRow, i);
            if (element < valueToEqual) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static boolean isMaxElementInColumn(Matrix<Integer> matrix, int indexColumn, int valueToEqual) {
        boolean result = true;
        for (int i = 0; i < matrix.getRows(); i++) {
            int element = matrix.getElement(i, indexColumn);
            if (element > valueToEqual) {
                result = false;
                break;
            }
        }
        return result;
    }

}
