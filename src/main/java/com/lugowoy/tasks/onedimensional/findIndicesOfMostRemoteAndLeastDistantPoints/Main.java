package com.lugowoy.tasks.onedimensional.findIndicesOfMostRemoteAndLeastDistantPoints;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.models.Point;
import com.lugowoy.helper.other.CheckerArray;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 03.07.2017. */

public class Main {

    public static void main(String[] args) {

        int numberPointOfPlane = getNumberQuantityPointsOfPlane();

        Array<Point<Double>> pointsArray = Array.create(numberPointOfPlane);

        fillArrayPoints(pointsArray);

        System.out.println("Points : ");
        Arrays.stream(pointsArray.toArray()).forEachOrdered(System.out::println);
        System.out.println();

        Finding<Array<Point<Double>>> finding = Finding::findIndicesOfMaxDistanceBetweenPoints;
        finding.find(pointsArray);

        System.out.println();

        finding = Finding::findIndicesOfMinDistanceBetweenPoints;
        finding.find(pointsArray);

    }

    private static int getNumberQuantityPointsOfPlane() {
        System.out.println("Enter the number points of the plane : ");
        Reader reader = Reader.getReader(new ReadingConsole());
        int numberQuantityPointOfPlane;
        while (true) {
            numberQuantityPointOfPlane = reader.readInt();
            if ((numberQuantityPointOfPlane > 0) && (numberQuantityPointOfPlane % 2 == 0)) {
                break;
            } else {
                System.out.println("The number points of the plane a must be positive and even number.");
                System.out.println("Re-enter : ");
            }
        }
        return numberQuantityPointOfPlane;
    }

    private static void fillArrayPoints(Array<Point<Double>> pointArray) {
        if (CheckerArray.checkArrayNonNull(pointArray)) {
            for (int i = 0; i < pointArray.getLength(); i++) {
                double coordinateX = GeneratorRandomNumber.generateDouble();
                double coordinateY = GeneratorRandomNumber.generateDouble();
                pointArray.set(i, Point.create(coordinateX, coordinateY));
            }
        }
    }

}
