package com.lugowoy.tasks.multidimensional.calculateMatrixNorms;

import com.lugowoy.helper.filling.matrixes.numbers.FillingMatrixRandomDoubleNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.*;

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

        Matrix<Double> matrix = Matrix.create(new FillingMatrixRandomDoubleNumbers().fill(rows, columns, NEGATIVE_DOUBLE_BOUND,
                                                                                                         POSITIVE_DOUBLE_BOUND));

        System.out.println("Matrix : ");
        System.out.println(matrix);

        CalculatorMatrixNorms calculatorMatrixNorms = CalculatorMatrixNorms::calculateMatrixColumnsNorm;
        double normMatrixRows = calculatorMatrixNorms.calculateMatrixNorm(matrix);

        calculatorMatrixNorms = CalculatorMatrixNorms::calculateMatrixRowsNorm;
        double normMatrixColumns = calculatorMatrixNorms.calculateMatrixNorm(matrix);

        System.out.printf("Norm of rows : %.3f", normMatrixRows);
        System.out.println();
        System.out.printf("Norm of columns : %.3f", normMatrixColumns);

    }

}
