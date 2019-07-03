package com.lugowoy.tasks.multidimensional.findSumOfMatrixElementsLocatedBetweenFirstAndSecondPositiveElementsOfEachRow;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomInteger;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;
import com.lugowoy.helper.other.MatrixAttributes;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.NEGATIVE_INTEGER_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;
import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_COLUMN;
import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_ROW;

/**
 * Find the sum of matrix elements located between the first and second positive elements of each row.
 * <p>
 * Created by Konstantin Lugowoy on 29.10.2018.
 */

public class Main {

    public static void main(String[] args) {

        MatrixAttributes matrixAttributes = new MatrixAttributes();
        matrixAttributes.setMatrixAttributes(new ReadingConsole(), System.out, MSG_ENTER_CONSOLE_ROW, MSG_ENTER_CONSOLE_COLUMN);

        Matrix<Integer> matrix = new Matrix<>(new FillingMatrixRandomInteger().fill(matrixAttributes.getRows(),
                                                                                    matrixAttributes.getColumns(),
                                                                                    NEGATIVE_INTEGER_BOUND,
                                                                                    POSITIVE_INTEGER_BOUND));

        System.out.println("Matrix : ");
        System.out.println(matrix);

        findSumOfMatrixElementsLocatedBetweenFirstAndSecondPositiveElementsOfEachRow(matrix);

    }

    private static void findSumOfMatrixElementsLocatedBetweenFirstAndSecondPositiveElementsOfEachRow(Matrix<Integer> matrix) {
        int tmpSum = 0;
        int sumAllElements = 0;
        boolean firstPositive = false;
        boolean secondPositive = false;
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                if (matrix.getElement(i, j) > 0 && firstPositive)
                    secondPositive = true;
                else if (firstPositive && !secondPositive){
                    tmpSum += matrix.getElement(i, j);
                }
                else if (matrix.getElement(i, j) > 0 && !firstPositive)
                    firstPositive = true;
            }
            if (firstPositive && !secondPositive) {
                tmpSum = 0;
            }
            firstPositive = false;
            secondPositive = false;
            sumAllElements += tmpSum;
            tmpSum = 0;
        }
        System.out.println("Result tmpSum elements : " + sumAllElements);
    }

}
