package com.lugowoy.tasks.onedimensional.determineTheNumberOfPairsOfPointsTheDistanceBetweenWhichIsMaximally;

/** Created by Konstantin Lugowoy on 27.03.2017. */

@FunctionalInterface
public interface Determinable {

    Point[] determine(Point[] pointsArray);

    static Point[] determineOfPairsOfPoints(Point[] pointsArray) {
        Point[] pairOfPoints = null;
        if (pointsArray.length > 2) {
            pairOfPoints = new Point[]{new Point(), new Point()};

            Distanceable distanceable = Distanceable::getDistanceOfPairOfThePoints;

            for (int i = 0; i < pointsArray.length - 1; i++) {
                for (int j = i + 1; j < pointsArray.length; j++) {
                    if (distanceable.getDistance(pairOfPoints[0], pairOfPoints[1]) < distanceable.getDistance(pointsArray[i], pointsArray[j])) {
                        pairOfPoints = new Point[]{pointsArray[i], pointsArray[j]};
                    }
                }

            }
        } else {
            System.out.println("Argument passed an array of points of incorrect size.");
        }
        return pairOfPoints;
    }

}
