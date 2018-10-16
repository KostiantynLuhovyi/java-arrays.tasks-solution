package com.lugowoy.tasks.onedimensional.determineNumberOfPairsOfPointsDistanceBetweenWhichIsMaximally;

/** Created by Konstantin Lugowoy on 27.03.2017. */

@FunctionalInterface
public interface Determinant {

    Point[] determine(Point[] pointsArray);

    static Point[] determineOfPairsOfPoints(Point[] pointsArray) {
        Point[] pairOfPoints = null;
        if (pointsArray.length > 2) {
            pairOfPoints = new Point[]{new Point(), new Point()};
            Distancing distancing = Distancing::getDistanceOfPairOfThePoints;
            for (int i = 0; i < pointsArray.length - 1; i++) {
                for (int j = i + 1; j < pointsArray.length; j++) {
                    if (distancing.getDistance(pairOfPoints[0], pairOfPoints[1]) < distancing.getDistance(pointsArray[i], pointsArray[j])) {
                        pairOfPoints = new Point[]{pointsArray[i], pointsArray[j]};
                    }
                }
            }
        } else {
            System.err.println("Argument passed an array of points of incorrect size.");
        }
        return pairOfPoints;
    }

}
