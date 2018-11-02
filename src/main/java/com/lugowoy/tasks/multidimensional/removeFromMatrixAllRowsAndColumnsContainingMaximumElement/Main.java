package com.lugowoy.tasks.multidimensional.removeFromMatrixAllRowsAndColumnsContainingMaximumElement;

import com.lugowoy.helper.filling.matrixes.numbers.FillingMatrixRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;

/**
 * Created by Konstantin Lugowoy on 31.10.2018.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());
    private static final int BOUND = 200;

    public static void main(String[] args) {

        System.out.println("Enter the number of rows for the matrix : ");
        int rows = READER.readInt();

        System.out.println("Enter the number of columns for the matrix : ");
        int columns = READER.readInt();

        Matrix<Integer> matrix = Matrix.create(new FillingMatrixRandomIntegerNumbers().fill(rows, columns, BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);


        IndexMaximumMatrixElement indexMax = new IndexMaximumMatrixElement(matrix);
        indexMax.setIndexesMatrixRowAndColumn();

        removeFromMatrixAllRowsAndColumnsContainingMaximumElement(matrix, indexMax.indexMaxElementMatrixRow,
                                                                          indexMax.indexMaxElementMatrixColumn);

        System.out.println("Result matrix : ");
        System.out.println(matrix);

    }

    private static void removeFromMatrixAllRowsAndColumnsContainingMaximumElement(Matrix<Integer> matrix, int indexMatrixRow,
                                                                                                          int indexMatrixColumn) {
        Integer[][] tmpInts = new Integer[matrix.getRows() - 1][matrix.getColumns() - 1];
        int row  = 0;
        for (int i = 0; i < matrix.getRows() - 1; i++) {
            if (i > indexMatrixRow - 1) {
                row = 1;
            }
            int column = 0;
            for (int j = 0; j < matrix.getColumns() - 1; j++) {
                if (j > indexMatrixColumn - 1) {
                    column = 1;
                }
                tmpInts[i][j] = matrix.getElement(i + row, j + column);
            }
        }
        matrix.setMatrix(tmpInts);
    }

    private static class IndexMaximumMatrixElement {

        private Matrix<Integer> matrix;

        private int indexMaxElementMatrixRow;
        private int indexMaxElementMatrixColumn;

        private IndexMaximumMatrixElement(Matrix<Integer> matrix) {
            this.matrix = matrix;
        }

        private void setIndexesMatrixRowAndColumn() {
            int resultMaxElement = Integer.MIN_VALUE;
            for (int i = 0; i < matrix.getRows(); i++) {
                for (int j = 0; j < matrix.getColumns(); j++) {
                    int elementOfMatrix = matrix.getElement(i, j);
                    if (elementOfMatrix > resultMaxElement) {
                        this.indexMaxElementMatrixRow = i;
                        this.indexMaxElementMatrixColumn = j;
                        resultMaxElement = elementOfMatrix;
                    }
                }
            }
        }

    }

}
