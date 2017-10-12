package com.lugowoy.tasks.onedimensional.defineTriangleForWhichDifferenceInNumberOfPointsOutsideAndInsideIsMinimal;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.creator.CreatorOfPointModels;
import com.lugowoy.helper.factory.models.array.FactoryOfDoubleArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfDoubleCoordinatesPointsOfArrayModels;
import com.lugowoy.helper.factory.models.points.FactoryOfPointsWithDoubleCoordinates;
import com.lugowoy.helper.filling.FillingArrayDoubleRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.models.points.PointOfDoubleCoordinates;
import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingDataUserInputInConsole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Created by Konstantin Lugowoy on 03.07.2017. */

public class Main {

    private static Reader reader = new Reader(new ReadingDataUserInputInConsole());

    public static void main(String[] args) {

        int sizeArray = getSizeArray();

        Array<Double> array = new CreatorOfArrayModels<>(
                                    new FactoryOfDoubleArrayModels()).create(
                                            new FillingArrayDoubleRandomNumbers().fill(sizeArray, -50.0, 50.0));

        System.out.println("Coordinates : ");
        System.out.println(array);
        System.out.println();

        Array<Point<Double>> pointArray = createAndFillArrayOfPoints(array);

        System.out.println("Points : ");
        System.out.println(pointArray);
        System.out.println();

        Definable<Array<Point<Double>>> arrayDefinable = Definable::defineTriangle;
        Array<Point<Double>> resultPointArray = arrayDefinable.define(pointArray);

        System.out.println("Result points of triangle : ");
        Arrays.stream(resultPointArray.getArray()).forEachOrdered(System.out::println);

    }

     private static int getSizeArray() {
        System.out.println("Enter the size of the array : ");
        int sizeArray;
        while (true) {
            sizeArray = reader.readInt();
            if (sizeArray % 2 == 0) {
                break;
            } else {
                System.out.println("Number of the size array must be a even number.");
                System.out.println("Re-enter : ");
            }
        }
        return sizeArray;
    }

     private static Point<Double> fillPointCoordinates(double xCoor, double yCoor) {
        return new CreatorOfPointModels<>(new FactoryOfPointsWithDoubleCoordinates()).create(xCoor, yCoor);
     }


    private static Array<Point<Double>> createAndFillArrayOfPoints(Array<Double> arrayOfCoordinates) {
        List<Point<Double>> pointsList = new ArrayList<>();
        int countForCreate = 0;
        for (int i = 0; i < arrayOfCoordinates.getArray().length; i++) {
            if (countForCreate == 1) {
                pointsList.add(fillPointCoordinates(arrayOfCoordinates.getArray()[i - 1], arrayOfCoordinates.getArray()[i]));
                countForCreate--;
            } else {
                countForCreate++;
            }
        }
        return new CreatorOfArrayModels<>(new FactoryOfDoubleCoordinatesPointsOfArrayModels()).create(pointsList.stream().toArray(PointOfDoubleCoordinates[]::new));
    }

}
