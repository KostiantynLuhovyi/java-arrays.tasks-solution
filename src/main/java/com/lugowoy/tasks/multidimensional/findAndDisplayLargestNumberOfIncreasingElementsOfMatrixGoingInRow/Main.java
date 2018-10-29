package com.lugowoy.tasks.multidimensional.findAndDisplayLargestNumberOfIncreasingElementsOfMatrixGoingInRow;

import com.lugowoy.helper.filling.matrixes.numbers.FillingMatrixRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.models.Matrix;

/**
 * Created by Konstantin Lugowoy on 28.10.2018.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    private static final int START_BOUND = -20;
    private static final int END_BOUND = 20;

    public static void main(String[] args) {

        System.out.println("Enter the number of rows for the matrix : ");
        int rows = READER.readInt();

        System.out.println("Enter the number of columns for the matrix : ");
        int columns = READER.readInt();

        Matrix<Integer> matrix = Matrix.create(new FillingMatrixRandomIntegerNumbers().fill(rows, columns, START_BOUND, END_BOUND));

        System.out.println("Matrix : ");
        System.out.println(matrix);

        System.out.println("Result sequence : ");
        System.out.println(findLargestNumberOfIncreasingElementsOfMatrixGoingInRow(matrix));

    }

    private static Array<Integer> findLargestNumberOfIncreasingElementsOfMatrixGoingInRow(Matrix<Integer> matrix) {
        Array<Integer> tmpArray = convertMatrixIntoArray(matrix);
        int countIncreasingElements = 0;
        int maxSequence = 0;
        int indexLastIncreasingElement = 0;
        for (int i = 0; i < tmpArray.getLength() - 1; i++) {
            if (tmpArray.get(i) < tmpArray.get(i + 1)) {
                countIncreasingElements++;
                if (countIncreasingElements > maxSequence) {
                    maxSequence = countIncreasingElements;
                    indexLastIncreasingElement = i + 1;
                }
            } else {
                countIncreasingElements = 0;
            }
        }
        Integer[] integers = new Integer[maxSequence + 1];
        System.arraycopy(tmpArray.toArray(new Integer[tmpArray.getLength()]), indexLastIncreasingElement - maxSequence,
                         integers, 0, maxSequence + 1);
        return Array.create(integers);
    }

    private static Array<Integer> convertMatrixIntoArray(Matrix<Integer> matrix) {
        Array<Integer> resultArray = Array.create(0);
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                resultArray.add(matrix.getElementMatrix(i, j));
            }
        }
        return resultArray;
    }

}
