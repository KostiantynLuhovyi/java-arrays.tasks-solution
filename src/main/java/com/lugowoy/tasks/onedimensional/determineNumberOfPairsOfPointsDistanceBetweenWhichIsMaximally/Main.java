package com.lugowoy.tasks.onedimensional.determineNumberOfPairsOfPointsDistanceBetweenWhichIsMaximally;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 27.03.2017. */

public class Main {

    private static final Determinant DETERMINANT = Determinant::determineOfPairsOfPoints;

    private static final int NUMBER_OF_POINTS = 20;

    public static void main(String[] args) {

        Point[] pointsArray = new Point[NUMBER_OF_POINTS];

        fill(pointsArray);

        System.out.println("Original points array : ");
        Arrays.stream(pointsArray).forEachOrdered(System.out::println);

        Point[] resultPointArray = DETERMINANT.determine(pointsArray);

        System.out.println("Result pair of points : ");
        Arrays.stream(resultPointArray).forEachOrdered(System.out::println);

    }

    private static void fill(Point[] pointsArray) {
        for (int i = 0; i < pointsArray.length; i++) {
            pointsArray[i] = new Point((Math.random() * 40) + 1, (Math.random() * 40) + 1);
        }
    }

}
