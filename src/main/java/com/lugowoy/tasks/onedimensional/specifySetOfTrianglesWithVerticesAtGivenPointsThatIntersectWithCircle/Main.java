package com.lugowoy.tasks.onedimensional.specifySetOfTrianglesWithVerticesAtGivenPointsThatIntersectWithCircle;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.creator.CreatorOfPointModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerCoordinatesPointsOfArrayModels;
import com.lugowoy.helper.factory.models.points.FactoryOfPointsWithIntegerCoordinates;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingDataUserInputInConsole;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 02.07.2017. */

public class Main {

    private static Reader reader = new Reader(new ReadingDataUserInputInConsole());

    public static void main(String[] args) {

        int numberOfPoints = getNumberOfPoints();

        Array<Point<Integer>> pointsArray = new CreatorOfArrayModels<>(new FactoryOfIntegerCoordinatesPointsOfArrayModels()).create(numberOfPoints);

        fillPointsArray(pointsArray);

        System.out.println();
        System.out.println("Points : ");
        Arrays.stream(pointsArray.getArray()).forEachOrdered(System.out::println);
        System.out.println();

        double radius = getRadius();

        System.out.println();
        System.out.println("Result : ");
        TrigonometricDeterminable<Array<Point<Integer>>, Double> trigonometricDeterminable = TrigonometricDeterminable::determineSetOfTrianglesWithVerticesAtGivenPointsThatIntersectWithCircle;
        trigonometricDeterminable.determine(pointsArray, radius);

    }

    private static int getNumberOfPoints() {
        System.out.println("Enter number of points : ");
        int numberOfPoints;
        while (true) {
            numberOfPoints = reader.readInt();
            if (numberOfPoints > 0) {
                break;
            } else {
                System.out.println("Incorrect enter data. Re-enter a positive number : ");
            }
        }
        return numberOfPoints;
    }

    private static double getRadius() {
        System.out.println("Enter the radius of the circle : ");
        double radius;
        while (true) {
            radius = reader.readInt();
            if (radius > 50) {
                break;
            } else {
                System.out.println("The radius of the circle must be greater than 50.");
                System.out.println("Re-enter : ");
            }
        }
        return radius;
    }

    private static void fillPointsArray(Array<Point<Integer>> pointsArray) {
        for (int i = 0; i < pointsArray.getArray().length; i++) {
            System.out.println("Enter coordinate X and Y : ");
            pointsArray.getArray()[i] = new CreatorOfPointModels<>(new FactoryOfPointsWithIntegerCoordinates()).create(reader.readInt(), reader.readInt());
        }

    }

}
