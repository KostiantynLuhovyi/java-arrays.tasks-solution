package com.lugowoy.tasks.onedimensional.determineTriangleForWhichDifferenceInNumberOfPointsOutsideAndInsideIsMinimal;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomDoubleNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.models.Point;

/** Created by Konstantin Lugowoy on 03.07.2017. */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    private static final Determinant<Array<Point<Double>>> DETERMINANT = Determinant::defineTriangle;

    private static final double START_BOUND = -50d;
    private static final double END_BOUND = 50d;

    public static void main(String[] args) {

        int lengthArray = enterLengthOfArray();

        Array<Double> array = Array.create(new FillingArrayRandomDoubleNumbers().fill(lengthArray, START_BOUND, END_BOUND));

        System.out.println("Coordinates : ");
        System.out.println(array);
        System.out.println();

        Array<Point<Double>> pointArray = createAndFillArrayOfPoints(array);

        System.out.println("Points : ");
        System.out.println(pointArray);
        System.out.println();

        Array<Point<Double>> resultPointArray = DETERMINANT.define(pointArray);

        System.out.println("Result points of triangle : " + resultPointArray);

    }

     private static int enterLengthOfArray() {
        System.out.println("Enter the size of the array : ");
        int sizeArray;
        while (true) {
            sizeArray = READER.readInt();
            if (sizeArray % 2 == 0) {
                break;
            } else {
                System.out.println("Number of the size array must be a even number. Re-enter : ");
            }
        }
        return sizeArray;
    }

     private static Point<Double> fillPointCoordinates(double coordinateX, double coordinateY) {
        return Point.create(coordinateX, coordinateY);
     }


    private static Array<Point<Double>> createAndFillArrayOfPoints(Array<Double> arrayOfCoordinates) {
        Array<Point<Double>> pointArray = Array.create(0);
        int countForCreate = 0;
        for (int i = 0; i < arrayOfCoordinates.getLength(); i++) {
            if (countForCreate == 1) {
                pointArray.add(fillPointCoordinates(arrayOfCoordinates.get(i - 1), arrayOfCoordinates.get(i)));
                countForCreate--;
            } else {
                countForCreate++;
            }
        }
        return pointArray;
    }

}
