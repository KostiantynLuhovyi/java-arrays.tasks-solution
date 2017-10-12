package com.lugowoy.tasks.onedimensional.findIndicesOfMostRemoteAndLeastDistantPoints;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.creator.CreatorOfPointModels;
import com.lugowoy.helper.factory.models.array.FactoryOfDoubleCoordinatesPointsOfArrayModels;
import com.lugowoy.helper.factory.models.points.FactoryOfPointsWithDoubleCoordinates;
import com.lugowoy.helper.generating.GeneratorDataRandomDouble;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingDataUserInputInConsole;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 03.07.2017. */

public class Main {

    public static void main(String[] args) {

        int numberPointOfPlane = getNumberQuantityPointsOfPlane();

        Array<Point<Double>> pointsArray = new CreatorOfArrayModels<>(
                                                new FactoryOfDoubleCoordinatesPointsOfArrayModels()).create(numberPointOfPlane);

        fillArrayPoints(pointsArray);

        System.out.println("\nPoints : ");
        Arrays.stream(pointsArray.getArray()).forEachOrdered(System.out::println);
        System.out.println();

        Findable<Array<Point<Double>>> findable = Findable::findIndicesOfMaxDistanceBetweenPoints;
        findable.find(pointsArray);

        System.out.println();

        findable = Findable::findIndicesOfMinDistanceBetweenPoints;
        findable.find(pointsArray);

    }

    private static int getNumberQuantityPointsOfPlane() {
        System.out.println("Enter the number points of the plane : ");
        int numberQuantityPointOfPlane;
        while (true) {
            numberQuantityPointOfPlane = new Reader(new ReadingDataUserInputInConsole()).readInt();
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
        for (int i = 0; i < pointArray.getArray().length; i++) {
            double coorX = GeneratorDataRandomDouble.generateDouble();
            double coorY = GeneratorDataRandomDouble.generateDouble();
            pointArray.getArray()[i] = new CreatorOfPointModels<>(
                                            new FactoryOfPointsWithDoubleCoordinates()).create(coorX, coorY);
        }
    }

}
