package com.lugowoy.tasks.multidimensional.roundAllElementsOfMatrixToInteger;

import com.lugowoy.helper.filling.matrixes.numbers.FillingMatrixRandomDoubleNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;

/**
 * Created by Konstantin Lugowoy on 07.11.2018.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());
    private static final double BOUND = 20.0;

    public static void main(String[] args) {

        System.out.println("Enter the number of rows for the matrix : ");
        int rows = READER.readInt();

        System.out.println("Enter the number of columns for the matrix : ");
        int columns = READER.readInt();

        Matrix<Double> matrix = Matrix.create(new FillingMatrixRandomDoubleNumbers().fill(rows, columns, BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        Matrix<Integer> integerMatrix = Matrix.create(matrix.getRows(), matrix.getColumns());
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                integerMatrix.setElement(i, j, (int) Math.round(matrix.getElement(i, j)));
            }
        }

        System.out.println("Result matrix : ");
        System.out.println(integerMatrix);

    }

}
