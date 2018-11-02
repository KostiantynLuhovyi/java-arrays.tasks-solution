package com.lugowoy.tasks.multidimensional.findSumOfMatrixElementsLocatedBetweenFirstAndSecondPositiveElementsOfEachRow;

import com.lugowoy.helper.filling.matrixes.numbers.FillingMatrixRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.NEGATIVE_INTEGER_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;

/**
 * Created by Konstantin Lugowoy on 29.10.2018.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter the number rows for the matrix : ");
        int rows = READER.readInt();

        System.out.println("Enter the number columns for the matrix : ");
        int columns = READER.readInt();

        Matrix<Integer> matrix = Matrix.create(new FillingMatrixRandomIntegerNumbers().fill(rows, columns, NEGATIVE_INTEGER_BOUND, POSITIVE_INTEGER_BOUND));

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
