package com.lugowoy.tasks.onedimensional.determineTheNumberOfPairsOfPointsTheDistanceBetweenWhichIsMaximally;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 27.03.2017. */

public class Main {

    private static final Determinable DETERMINABLE = Determinable::determineOfPairsOfPoints;

    public static void main(String[] args) {

        Point[] pointsArray = new Point[20];

        fill(pointsArray);

        System.out.println("Original points array : ");
        Arrays.stream(pointsArray).forEachOrdered(System.out::println);

        Point[] resultPointArray = DETERMINABLE.determine(pointsArray);

        System.out.println("Result pair of points : ");
        Arrays.stream(resultPointArray).forEachOrdered(System.out::println);

    }

    private static void fill(Point[] pointsArray) {
        for (int i = 0; i < pointsArray.length; i++) {
            pointsArray[i] = new Point((Math.random() * 40) + 1, (Math.random() * 40) + 1);
        }
    }

}
