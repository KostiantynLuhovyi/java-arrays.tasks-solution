package com.lugowoy.tasks.onedimensional.findIndicesOfMostRemoteAndLeastDistantPoints;

import com.lugowoy.helper.calculating.CalculableOnTheTwoVariables;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;

import java.util.Objects;

/** Created by Konstantin Lugowoy on 03.07.2017. */

@FunctionalInterface
public interface Findable<T> {

    CalculableOnTheTwoVariables<Double, Point<Double>, Point<Double>> CALCULATING_DISTANCE_BETWEEN_TWO_POINTS = (kFirst, vSecond)
            -> Math.sqrt((Math.pow(kFirst.getCoordinateX() - vSecond.getCoordinateX(), 2)) + Math.pow(kFirst.getCoordinateY() - vSecond.getCoordinateY(), 2));


    void find(T t);


    static void findIndicesOfMaxDistanceBetweenPoints(Array<Point<Double>> pointArray) {
        int firstIndex = -1, secondIndex = -1;
        double tmpMax;
        if (Objects.nonNull(pointArray)) {
            if ((Objects.nonNull(pointArray.getArray()) && (pointArray.getArray().length > 0))) {
                double distanceResult = CALCULATING_DISTANCE_BETWEEN_TWO_POINTS.calculate(pointArray.getArray()[0], pointArray.getArray()[1]);
                for (int i = 1; i < pointArray.getArray().length - 1; i++) {
                    for (int j = i + 1; j < pointArray.getArray().length; j++) {
                        tmpMax = CALCULATING_DISTANCE_BETWEEN_TWO_POINTS.calculate(pointArray.getArray()[i], pointArray.getArray()[j]);
                        if (tmpMax > distanceResult) {
                            distanceResult = tmpMax;
                            firstIndex = i;
                            secondIndex = j;
                        }
                    }
                }
                System.out.printf("Max distance between two points with index %d and %d is equal %f", firstIndex, secondIndex, distanceResult);
            }
        }

    }

    static void findIndicesOfMinDistanceBetweenPoints(Array<Point<Double>> pointArray) {
        int firstIndex = -1, secondIndex = -1;
        double distanceResult = -1;
        if (Objects.nonNull(pointArray)) {
            if ((Objects.nonNull(pointArray.getArray()) && (pointArray.getArray().length > 0))) {
                double tmpMin = CALCULATING_DISTANCE_BETWEEN_TWO_POINTS.calculate(pointArray.getArray()[0], pointArray.getArray()[1]);
                for (int i = 1; i < pointArray.getArray().length - 1; i++) {
                    for (int j = i + 1; j < pointArray.getArray().length; j++) {
                        distanceResult = CALCULATING_DISTANCE_BETWEEN_TWO_POINTS.calculate(pointArray.getArray()[i], pointArray.getArray()[j]);
                        if (distanceResult < tmpMin) {
                            tmpMin = distanceResult;
                            firstIndex = i;
                            secondIndex = j;
                        }
                    }
                }
                System.out.printf("Min distance between two points with index %d and %d is equal %f", firstIndex, secondIndex, distanceResult);
            }
        }

    }

}
