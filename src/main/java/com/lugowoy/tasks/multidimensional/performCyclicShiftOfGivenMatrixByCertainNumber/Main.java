package com.lugowoy.tasks.multidimensional.performCyclicShiftOfGivenMatrixByCertainNumber;

import com.lugowoy.helper.filling.matrixes.numbers.FillingMatrixRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;

/**
 * Created by Konstantin Lugowoy on 28.10.2018.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    private static final int BOUND = 20;

    public static void main(String[] args) {

        System.out.println("Enter the number of rows for the matrix :");
        int rows = READER.readInt();

        System.out.println("Enter the number of columns for the matrix : ");
        int columns = READER.readInt();

        Matrix<Integer> matrix = Matrix.create(new FillingMatrixRandomIntegerNumbers().fill(rows, columns, BOUND));

        System.out.println("Original matrix : ");
        System.out.println(matrix);

        int numberToShiftMatrix = enterNumberToShiftMatrix(rows);

        System.out.println("Select an action to perform : ");
        System.out.println("Press 1, to shift the matrix to the right.");
        System.out.println("Press 2, to shift the matrix to the left.");
        System.out.println("Press 3, to shift the matrix to the up.");
        System.out.println("Press 4, to shift the matrix to the down.");
        int selectValue = selectionActionToPerform();

        Shifter<Integer> shifter;
        switch (selectValue) {
            case 1 :
                shifter = ShifterIntegerMatrix::shiftMatrixToRight;
                shifter.shift(matrix, numberToShiftMatrix);
                break;
            case 2 :
                shifter = ShifterIntegerMatrix::shiftMatrixToLeft;
                shifter.shift(matrix, numberToShiftMatrix);
                break;
            case 3 :
                shifter = ShifterIntegerMatrix::shiftMatrixToUp;
                shifter.shift(matrix, numberToShiftMatrix);
                break;
            case 4 :
                shifter = ShifterIntegerMatrix::shiftMatrixToDown;
                shifter.shift(matrix, numberToShiftMatrix);
                break;
        }

        System.out.println("Result matrix : ");
        System.out.println(matrix);

    }

    private static int enterNumberToShiftMatrix(int rows) {
        int resultNumber;
        System.out.println("Enter the number to shift the matrix");
        while (true) {
            resultNumber = READER.readInt();
            if (resultNumber >= 0 && resultNumber <= rows) {
                break;
            } else {
                System.out.println("Incorrect value. Re-enter : ");
            }
        }
        return resultNumber;
    }

    private static int selectionActionToPerform() {
        int resultSelection;
        while (true) {
            resultSelection = READER.readInt();
            if (resultSelection > 0 && resultSelection <= 4) {
                break;
            } else {
                System.out.println("Incorrect value. Re-enter : ");
            }
        }
        return resultSelection;
    }

}

