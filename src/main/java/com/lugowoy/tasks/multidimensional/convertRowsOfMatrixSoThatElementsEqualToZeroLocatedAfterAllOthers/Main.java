package com.lugowoy.tasks.multidimensional.convertRowsOfMatrixSoThatElementsEqualToZeroLocatedAfterAllOthers;

import com.lugowoy.helper.filling.matrixes.numbers.FillingMatrixRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;

/**
 * Created by Konstantin Lugowoy on 06.11.2018.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter the number of rows for the matrix : ");
        int rows = READER.readInt();

        System.out.println("Enter the number of columns for the matrix : ");
        int columns = READER.readInt();

        Matrix<Integer> matrix = Matrix.create(new FillingMatrixRandomIntegerNumbers().fill(rows, columns, POSITIVE_INTEGER_BOUND));

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