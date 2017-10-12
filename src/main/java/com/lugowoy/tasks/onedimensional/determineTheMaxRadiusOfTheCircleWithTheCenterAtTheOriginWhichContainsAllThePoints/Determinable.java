package com.lugowoy.tasks.onedimensional.determineTheMaxRadiusOfTheCircleWithTheCenterAtTheOriginWhichContainsAllThePoints;

import java.util.Objects;

/** Created by Konstantin Lugowoy on 14.05.2017. */

@FunctionalInterface
public interface Determinable {

    double determine(ArrayOfCoordinatesOfThePointsOfThePlane arrayOfCoordinates);

    static double determineTeMaxRadius(ArrayOfCoordinatesOfThePointsOfThePlane arrayOfCoordinates) {
        double result = 0;
        if (Objects.nonNull(arrayOfCoordinates)) {
            if (Objects.nonNull(arrayOfCoordinates.getCoordinatesOfPoints())) {
                if ((arrayOfCoordinates.getCoordinatesOfPoints().length % 2 == 0)
                        && (arrayOfCoordinates.getCoordinatesOfPoints().length != 0)) {
                    for (int i = 0; i < arrayOfCoordinates.getCoordinatesOfPoints().length - 1; i++) {
                        result = result < (arrayOfCoordinates.getCoordinatesOfPoints()[i] * arrayOfCoordinates.getCoordinatesOfPoints()[i]
                                        + arrayOfCoordinates.getCoordinatesOfPoints()[i + 1] * arrayOfCoordinates.getCoordinatesOfPoints()[i + 1])
                                ? (arrayOfCoordinates.getCoordinatesOfPoints()[i] * arrayOfCoordinates.getCoordinatesOfPoints()[i]
                                        + arrayOfCoordinates.getCoordinatesOfPoints()[i + 1] * arrayOfCoordinates.getCoordinatesOfPoints()[i + 1])
                                    : result;

                    }
                }
            }
        }
        return result;
    }

}
