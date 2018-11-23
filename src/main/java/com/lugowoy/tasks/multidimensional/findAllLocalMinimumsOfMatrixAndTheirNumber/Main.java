package com.lugowoy.tasks.multidimensional.findAllLocalMinimumsOfMatrixAndTheirNumber;

import com.lugowoy.helper.filling.matrixes.numbers.FillingMatrixRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;

/**
 * Created by Konstantin Lugowoy on 23.11.2018.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());
    private static final int BOUND = 100;

    public static void main(String[] args) {

        System.out.println("Enter the number of rows for the matrix : ");
        int rows = READER.readInt();

        System.out.println("Enter the number of columns for the matrix : ");
        int columns = READER.readInt();

        Matrix<Integer> matrix = Matrix.create(new FillingMatrixRandomIntegerNumbers().fill(rows, columns, BOUND));

        System.out.println("Matrix : ");
        System.out.println(matrix);

        findAllLocalMinimumsOfMatrix(matrix);

    }

    private static void findAllLocalMinimumsOfMatrix(Matrix<Integer> matrix) {
        int countLocalMinimum = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                if (isLocalMinimum(matrix, i, j)) {
                    System.out.println("The local minimum by the index of row " + i
                                                                + " and the index of column " + j
                                                                         + " is equal to : " + matrix.getElement(i, j) + " .");
                    countLocalMinimum++;
                }
            }
        }
        if (countLocalMinimum == 0) {
            System.out.println("Local minimums not found.");
        }
    }

    private static boolean isLocalMinimum(Matrix<Integer> matrix, int row, int column){
        boolean result = false;

        int countRowFrom = row - 1;
        int countRowFor = row + 1;
        int countColumnFrom = column - 1;
        int countColumnFor = column + 1;

        //upper left corner
        if ((row == 0) && (column == 0)){
            countRowFrom = 0;
            countRowFor = row + 1;
            countColumnFrom = 0;
            countColumnFor = column + 1;
        }
        //top row of the matrix (corner corners)
        else if ((row == 0) && (column > 0) && (column < matrix.getColumns() - 1)){
            countRowFrom = 0;
            countRowFor = row + 1;
            countColumnFrom = column - 1;
            countColumnFor = column + 1;
        }
        //upper right corner
        else if ((row == 0) && (column == matrix.getColumns() - 1)){
            countRowFrom = 0;
            countRowFor = row + 1;
            countColumnFrom = column - 1;
            countColumnFor = column;
        }
        //first column (except corner)
        else if ((column == 0) && (row > 0) && (row < matrix.getRows() - 1)){
            countRowFrom = row - 1;
            countRowFor = row + 1;
            countColumnFrom = 0;
            countColumnFor = column + 1;
        }
        //last column of matrix (except angular)
        else if ((column == matrix.getColumns() - 1) && (row > 0) && (row < matrix.getRows() - 1)){
            countRowFrom = row - 1;
            countRowFor = row + 1;
            countColumnFrom = column - 1;
            countColumnFor = column;
        }
        //bottom left corner
        else if ((column == 0) && (row == matrix.getRows() - 1)){
            countRowFrom = row - 1;
            countRowFor = row;
            countColumnFrom = 0;
            countColumnFor = column + 1;
        }
        //bottom line of the matrix (except angular)
        else if ((column > 0) && (column < matrix.getColumns() - 1) && (row == matrix.getRows() - 1)){
            countRowFrom = row - 1;
            countRowFor = row;
            countColumnFrom = column - 1;
            countColumnFor = column + 1;
        }
        //bottom right corner
        else if ((row == matrix.getRows() - 1) && (column == matrix.getColumns() - 1)){
            countRowFrom = row - 1;
            countRowFor = row;
            countColumnFrom = column - 1;
            countColumnFor = column;
        }

        for (int i = countRowFrom; i <= countRowFor; i++) {
            for (int j = countColumnFrom; j <= countColumnFor; j++) {
                if ((i == row)&&(j == column)){
                    result = true;
                }
                else if (matrix.getElement(i, j) <= matrix.getElement(row, column)) {
                    result = false;
                }
            }
        }
        return result;
    }

}
