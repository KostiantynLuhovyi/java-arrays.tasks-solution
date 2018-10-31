package com.lugowoy.tasks.multidimensional.buildMatrixSubtractingFromElementsOfEachRowOfMatrixItsArithmeticAverage;

import com.lugowoy.helper.filling.matrixes.numbers.FillingMatrixRandomDoubleNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_DOUBLE_BOUND;

/**
 * Created by Konstantin Lugowoy on 30.10.2018.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter the number of rows for the matrix : ");
        int rows = READER.readInt();

        System.out.println("Enter the number of columns for the matrix : ");
        int columns = READER.readInt();

        Matrix<Double> matrix = Matrix.create(new FillingMatrixRandomDoubleNumbers().fill(rows, columns, POSITIVE_DOUBLE_BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        subtractArithmeticAverageValueFromElementsOfMatrix(matrix);

        System.out.println("Result matrix : ");
        System.out.println(matrix);

    }

    private static void subtractArithmeticAverageValueFromElementsOfMatrix(Matrix<Double> matrix) {
        double resultArithmeticAverage = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                resultArithmeticAverage += matrix.getElementMatrix(i, j);
            }
            resultArithmeticAverage /= matrix.getColumns();
            for (int j = 0; j < matrix.getColumns(); j++) {
                matrix.setElementMatrix(i, j, new BigDecimal(matrix.getElementMatrix(i, j) - resultArithmeticAverage).setScale(2, RoundingMode.HALF_DOWN).doubleValue());
            }
            resultArithmeticAverage = 0;
        }
    }

}
