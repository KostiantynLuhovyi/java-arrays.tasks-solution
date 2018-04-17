package com.lugowoy.tasks.onedimensional.determineMaxRadiusOfCircleWithCenterAtOriginWhichContainsAllPoints;

/** Created by Konstantin Lugowoy on 14.05.2017. */

@FunctionalInterface
public interface Determinant {

    double determine(ArrayOfCoordinates arrayOfCoordinates);

    static double determineTeMaxRadius(ArrayOfCoordinates arrayOfCoordinates) {
        double result = 0;
            if (arrayOfCoordinates != null) {
                if (arrayOfCoordinates.getCoordinatesOfPoints() != null) {
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
