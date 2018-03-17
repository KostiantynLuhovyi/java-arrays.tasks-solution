package com.lugowoy.tasks.onedimensional.specifySetOfTrianglesWithVerticesAtGivenPointsThatIntersectWithCircle;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayPoints;
import com.lugowoy.helper.filling.array.points.FillingArrayOfPointsWithCoordinatesReadIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 02.07.2017. */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        int numberOfPoints = enterNumberOfPoints();

        Array<Point<Integer>> pointsArray = FactoryArray.getFactoryArray(
                                                    new CreatorArrayPoints<Integer>()).create(
                                                        new FillingArrayOfPointsWithCoordinatesReadIntegerNumbers(READER).fill(numberOfPoints));

        /*fillPointsArray(pointsArray);*/

        System.out.println();
        System.out.println("Points : ");
        Arrays.stream(pointsArray.getArray()).forEachOrdered(System.out::println);
        System.out.println();

        double radius = enterRadius();

        System.out.println();
        System.out.println("Result : ");
        TrigonometricDeterminant<Array<Point<Integer>>, Double> trigonometricDeterminant =
                      TrigonometricDeterminant::determineSetOfTrianglesWithVerticesAtGivenPointsThatIntersectWithCircle;
        trigonometricDeterminant.determine(pointsArray, radius);

    }

    private static int enterNumberOfPoints() {
        System.out.println("Enter number of points : ");
        int numberOfPoints;
        while (true) {
            numberOfPoints = READER.readInt();
            if (numberOfPoints > 0) {
                break;
            } else {
                System.out.println("Incorrect enter data. Re-enter a positive number : ");
            }
        }
        return numberOfPoints;
    }

    private static double enterRadius() {
        System.out.println("Enter the radius of the circle : ");
        double radius;
        while (true) {
            radius = READER.readInt();
            if (radius > 50) {
                break;
            } else {
                System.out.println("The radius of the circle must be greater than 50.");
                System.out.println("Re-enter : ");
            }
        }
        return radius;
    }

    /*private static void fillPointsArray(Array<Point<Integer>> pointsArray) {
        try {
        if ()
        for (int i = 0; i < pointsArray.getArray().length; i++) {
            System.out.println("Enter coordinate X and Y : ");
            pointsArray.getArray()[i] = new CreatorOfPointModels<>(new FactoryOfPointsWithIntegerCoordinates()).create(READER.readInt(), READER.readInt());
        }

    }*/

}
