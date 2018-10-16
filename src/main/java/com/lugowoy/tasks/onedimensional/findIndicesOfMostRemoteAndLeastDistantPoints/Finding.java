package com.lugowoy.tasks.onedimensional.findIndicesOfMostRemoteAndLeastDistantPoints;

import com.lugowoy.helper.calculating.CalculationUsingTwoParameters;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.models.Point;
import com.lugowoy.helper.other.CheckerArray;

/** Created by Konstantin Lugowoy on 03.07.2017. */

@FunctionalInterface
public interface Finding<T> {

    CalculationUsingTwoParameters<Double, Point<Double>, Point<Double>> CALCULATING = (kFirst, vSecond) ->
                                                                            Math.sqrt((Math.pow(kFirst.getCoordinateX() - vSecond.getCoordinateX(), 2))
                                                                                    + Math.pow(kFirst.getCoordinateY() - vSecond.getCoordinateY(), 2));

    void find(T t);

    static void findIndicesOfMaxDistanceBetweenPoints(Array<Point<Double>> pointArray) {
        int firstIndex = -1, secondIndex = -1;
        double tmpMax;
        if (CheckerArray.checkArrayNonNull(pointArray)) {
            if (CheckerArray.checkLengthOfArrayIsGreaterZero(pointArray.getLength())) {
                double distanceResult = CALCULATING.calculate(pointArray.get(0), pointArray.get(1));
                for (int i = 1; i < pointArray.getLength() - 1; i++) {
                    for (int j = i + 1; j < pointArray.getLength(); j++) {
                        tmpMax = CALCULATING.calculate(pointArray.get(i), pointArray.get(j));
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
        if (CheckerArray.checkArrayNonNull(pointArray)) {
            if (CheckerArray.checkLengthOfArrayIsGreaterZero(pointArray.getLength())) {
                double tmpMin = CALCULATING.calculate(pointArray.get(0), pointArray.get(1));
                for (int i = 1; i < pointArray.getLength() - 1; i++) {
                    for (int j = i + 1; j < pointArray.getLength(); j++) {
                        distanceResult = CALCULATING.calculate(pointArray.get(i), pointArray.get(j));
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
