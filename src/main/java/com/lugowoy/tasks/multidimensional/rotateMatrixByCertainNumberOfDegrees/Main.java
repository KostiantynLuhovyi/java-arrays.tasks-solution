package com.lugowoy.tasks.multidimensional.rotateMatrixByCertainNumberOfDegrees;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomInteger;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;
import com.lugowoy.helper.other.MatrixAttributes;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;
import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_COLUMN;
import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_ROW;

/**
 * Rotation of the matrix by a certain number of degrees.
 * <p>
 * Created by Konstantin Lugowoy on 30.10.2018.
 */

public class Main {

    public static void main(String[] args) {

        MatrixAttributes matrixAttributes = new MatrixAttributes();
        matrixAttributes.setMatrixAttributes(new ReadingConsole(), System.out, MSG_ENTER_CONSOLE_ROW, MSG_ENTER_CONSOLE_COLUMN);

        Matrix<Integer> matrix = new Matrix<>(new FillingMatrixRandomInteger().fill(matrixAttributes.getRows(),
                                                                                    matrixAttributes.getColumns(),
                                                                                    POSITIVE_INTEGER_BOUND));

        System.out.println("Matrix : ");
        System.out.println(matrix);

        RotatorMatrix<Integer> rotatorMatrix = RotatorIntegerMatrixClockwise::rotateMatrixTo90Degrees;
        rotatorMatrix.rotateMatrix(matrix);

        System.out.println("Result to rotate matrix clockwise to 90 degrees : ");
        System.out.println(matrix);

    }

}
