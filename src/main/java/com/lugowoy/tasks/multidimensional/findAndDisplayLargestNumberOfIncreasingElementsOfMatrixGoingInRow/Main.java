package com.lugowoy.tasks.multidimensional.findAndDisplayLargestNumberOfIncreasingElementsOfMatrixGoingInRow;

import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomInteger;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.models.Matrix;
import com.lugowoy.helper.other.MatrixAttributes;

/**
 * Find and display the largest number of increasing elements of the matrix, going in a row.
 * <p>
 * Created by Konstantin Lugowoy on 28.10.2018.
 */

public class Main {

    private static final int LOWER_BOUND = -20;
    private static final int UPPER_BOUND = 20;

    public static void main(String[] args) {

        MatrixAttributes matrixAttributes = MatrixAttributes.getInstanceMatrixAttributes(new ReadingConsole());

        Matrix<Integer> matrix = new Matrix<>(new FillingMatrixRandomInteger().fill(matrixAttributes.getRows(),
                                                                                    matrixAttributes.getColumns(),
                                                                                    LOWER_BOUND, UPPER_BOUND));

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
        return new Array<>(integers);
    }

    private static Array<Integer> convertMatrixIntoArray(Matrix<Integer> matrix) {
        Array<Integer> resultArray = new Array<>(0);
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                resultArray.add(matrix.getElement(i, j));
            }
        }
        return resultArray;
    }

}
