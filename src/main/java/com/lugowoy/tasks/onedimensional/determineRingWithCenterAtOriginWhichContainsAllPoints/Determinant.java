package com.lugowoy.tasks.onedimensional.determineRingWithCenterAtOriginWhichContainsAllPoints;

/** Created by Konstantin Lugowoy on 16.05.2017. */

@FunctionalInterface
public interface Determinant<T> {

    void determine(ArrayOfCoordinates<T> arrayOfCoordinates);

    static void determineRingWhichContainsAllCoordinatesOfPoints(ArrayOfCoordinates<Double> arrayOfCoordinates) {
        Double[] resultCoordinates = {Double.MAX_VALUE, Double.MIN_VALUE};
        if (arrayOfCoordinates != null) {
            if (arrayOfCoordinates.getArrayOfCoordinates() != null) {
                if ((arrayOfCoordinates.getArrayOfCoordinates().length > 0)
                        && (arrayOfCoordinates.getArrayOfCoordinates().length % 2 == 0)) {
                    for (int i = 0; i < arrayOfCoordinates.getArrayOfCoordinates().length; i += 2) {
                        double radius = getRadius(arrayOfCoordinates, i);
                        resultCoordinates[0] = radius < resultCoordinates[0] ? radius : resultCoordinates[0];
                        resultCoordinates[1] = radius > resultCoordinates[1] ? radius : resultCoordinates[1];
                    }
                    resultCoordinates[0] = Math.sqrt(resultCoordinates[0]);
                    resultCoordinates[1] = Math.sqrt(resultCoordinates[1]);
                    System.out.printf("The circle containing all points has %.2f the radius " +
                                      "of the inner circle and %.2f the radius of the outer circle.",
                                                                            resultCoordinates[0], resultCoordinates[1]);
                }
            }
        }
    }

    static double getRadius(ArrayOfCoordinates<Double> arrayOfCoordinates, int i) {
        return arrayOfCoordinates.getArrayOfCoordinates()[i] * arrayOfCoordinates.getArrayOfCoordinates()[i]
                + arrayOfCoordinates.getArrayOfCoordinates()[i + 1] * arrayOfCoordinates.getArrayOfCoordinates()[i + 1];
    }

}
