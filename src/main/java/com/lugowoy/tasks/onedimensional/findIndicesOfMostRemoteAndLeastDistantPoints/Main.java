package com.lugowoy.tasks.onedimensional.findIndicesOfMostRemoteAndLeastDistantPoints;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.FactoryPoint;
import com.lugowoy.helper.factory.creator.CreatorArrayPoints;
import com.lugowoy.helper.factory.creator.CreatorPoint;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.other.ArrayChecker;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 03.07.2017. */

public class Main {

    public static void main(String[] args) {

        int numberPointOfPlane = getNumberQuantityPointsOfPlane();

        Array<Point<Double>> pointsArray = FactoryArray.getFactoryArray(new CreatorArrayPoints<Double>()).create(numberPointOfPlane);

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
        try {
            if (ArrayChecker.checkArrayNonNull(pointArray)) {
                for (int i = 0; i < pointArray.getLength(); i++) {
                    double coordinateX = GeneratorRandomNumber.generateDouble();
                    double coordinateY = GeneratorRandomNumber.generateDouble();
                    pointArray.set(i, FactoryPoint.getFactoryPoint(new CreatorPoint<Double>()).create(coordinateX, coordinateY));
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
