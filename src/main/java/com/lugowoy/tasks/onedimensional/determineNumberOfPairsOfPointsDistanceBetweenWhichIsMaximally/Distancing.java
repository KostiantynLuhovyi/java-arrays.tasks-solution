package com.lugowoy.tasks.onedimensional.determineNumberOfPairsOfPointsDistanceBetweenWhichIsMaximally;

/** Created by Konstantin Lugowoy on 27.03.2017. */

@FunctionalInterface
public interface Distancing {

    double getDistance(Point thisPoint, Point thatPoint);

    static double getDistanceOfPairOfThePoints(Point thisPoint, Point thatPoint) {
        return Math.hypot(thisPoint.getX() - thatPoint.getX(), thisPoint.getY() - thatPoint.getY());
    }

}
