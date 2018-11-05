package com.lugowoy.tasks.multidimensional.moveMinimumMatrixElementToSpecifiedLocationUsingPermutationOfRowsAndColumns;

import com.lugowoy.helper.filling.matrixes.numbers.FillingMatrixRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;

/**
 * Created by Konstantin Lugowoy on 05.11.2018.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());
    private static final int BOUND = 200;

    public static void main(String[] args) {

        System.out.println("Enter the number of rows for the matrix : ");
        int rows = READER.readInt();

        System.out.println("Enter the number of column for the matrix : ");
        int columns = READER.readInt();

        Matrix<Integer> matrix = Matrix.create(new FillingMatrixRandomIntegerNumbers().fill(rows, columns, BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        System.out.println("Enter the number of row for move : ");
        int indexRowToMove = READER.readInt();
        System.out.println("Enter the number of column for move : ");
        int indexColumnToMove = READER.readInt();

        IndexMinElement indexMinElement = new IndexMinElement();
        indexMinElement.findAndSetIndexesMinElement(matrix);
        int indexRowMinElement = indexMinElement.getIndexRowMinElement();
        int indexColumnMinElement = indexMinElement.getIndexColumnMinElement();

        moveMinimumMatrixElementToSpecifiedLocation(matrix, indexRowMinElement, indexColumnMinElement, indexRowToMove, indexColumnToMove);

        System.out.println("Result matrix after move minimal element : ");
        System.out.println(matrix);

    }

    private static void moveMinimumMatrixElementToSpecifiedLocation(Matrix<Integer> matrix, int indexRowMinElement, int indexColumnMinElement,
                                                                                           int indexRowToMove, int indexColumnToMove) {
        if (indexRowToMove <= matrix.getRows() && indexColumnToMove <= matrix.getColumns()) {
            for (int i = 0; i < matrix.getRows(); i++) {
                int tmp = matrix.getElement(indexRowMinElement, i);
                matrix.setElement(indexRowMinElement, i, matrix.getElement(indexRowToMove, i));
                matrix.setElement(indexRowToMove, i, tmp);
            }
            for (int i = 0; i < matrix.getColumns(); i++) {
                int tmp = matrix.getElement(i, indexColumnMinElement);
                matrix.setElement(i, indexColumnMinElement, matrix.getElement(i, indexColumnToMove));
                matrix.setElement(i, indexColumnToMove, tmp);
            }
        } else {
            System.err.println("Incorrect indexes arguments.");
        }
    }

    private static class IndexMinElement {

        private int indexRowMinElement = 0;
        private int indexColumnMinElement = 0;

        public void findAndSetIndexesMinElement(Matrix<Integer> matrix) {
            int minElement = Integer.MAX_VALUE;
            for (int i = 0; i < matrix.getRows(); i++) {
                for (int j = 0; j < matrix.getColumns(); j++) {
                    int element = matrix.getElement(i, j);
                    if (element < minElement) {
                        minElement = element;
                        this.indexRowMinElement = i;
                        this.indexColumnMinElement = j;
                    }
                }
            }
        }

        public int getIndexRowMinElement() {
            return indexRowMinElement;
        }

        public int getIndexColumnMinElement() {
            return indexColumnMinElement;
        }

    }

}
