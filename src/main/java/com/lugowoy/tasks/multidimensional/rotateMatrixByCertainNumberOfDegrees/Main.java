package com.lugowoy.tasks.multidimensional.rotateMatrixByCertainNumberOfDegrees;

import com.lugowoy.helper.filling.matrixes.numbers.FillingMatrixRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;

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

        Matrix<Integer> matrix = Matrix.create(new FillingMatrixRandomIntegerNumbers().fill(rows, columns, POSITIVE_INTEGER_BOUND));

        System.out.println("Matrix : ");
        System.out.println(matrix);

        RotatorMatrix<Integer> rotatorMatrix = RotatorIntegerMatrixClockwise::rotateMatrixTo90Degrees;
        rotatorMatrix.rotateMatrix(matrix);

        System.out.println("Result to rotate matrix clockwise to 90 degrees : ");
        System.out.println(matrix);

    }

}
