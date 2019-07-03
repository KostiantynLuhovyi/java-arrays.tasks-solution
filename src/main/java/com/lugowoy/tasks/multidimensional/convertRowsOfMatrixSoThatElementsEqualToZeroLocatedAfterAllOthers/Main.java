package com.lugowoy.tasks.multidimensional.convertRowsOfMatrixSoThatElementsEqualToZeroLocatedAfterAllOthers;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomInteger;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;
import com.lugowoy.helper.other.MatrixAttributes;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;
import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_COLUMN;
import static com.lugowoy.helper.other.MatrixAttributes.MSG_ENTER_CONSOLE_ROW;

/**
 * Created by Konstantin Lugowoy on 06.11.2018.
 */

public class Main {

    public static void main(String[] args) {

        MatrixAttributes matrixAttributes = new MatrixAttributes();
        matrixAttributes.setMatrixAttributes(new ReadingConsole(), System.out, MSG_ENTER_CONSOLE_ROW, MSG_ENTER_CONSOLE_COLUMN);

        Matrix<Integer> matrix = new Matrix<>(new FillingMatrixRandomInteger().fill(matrixAttributes.getRows(),
                                                                                    matrixAttributes.getColumns(),
                                                                                    POSITIVE_INTEGER_BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        convertRowsOfMatrixSoThatZeroElementLocatedAfterOther(matrix);

        System.out.println("Result matrix : ");
        System.out.println(matrix);

    }

    private static void convertRowsOfMatrixSoThatZeroElementLocatedAfterOther(Matrix<Integer> matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            int n = 0;
            Integer[] tmp = createAndFill(matrix.getColumns());
            for (int j = 0; j < matrix.getColumns(); j++) {
                int element = matrix.getElement(i, j);
                if (element != 0) {
                    tmp[n++] = element;
                }
            }
            matrix.setColumn(tmp, i);
        }
    }

    private static Integer[] createAndFill(int length) {
        Integer[] integers = new Integer[length];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = 0;
        }
        return integers;
    }

}
