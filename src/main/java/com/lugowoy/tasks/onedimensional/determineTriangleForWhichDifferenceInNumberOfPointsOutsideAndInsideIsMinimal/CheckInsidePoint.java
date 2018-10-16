package com.lugowoy.tasks.onedimensional.determineTriangleForWhichDifferenceInNumberOfPointsOutsideAndInsideIsMinimal;

import com.lugowoy.helper.calculating.CalculationUsingThreeParameters;
import com.lugowoy.helper.models.Point;

/** Created by Konstantin Lugowoy on 08.07.2017. */

@FunctionalInterface
public interface CheckInsidePoint {

    CalculationUsingThreeParameters<Double, Point<Double>, Point<Double>, Point<Double>> CALCULATION = (kFirst, vSecond, zThird) -> {
        double tmpResFirst = Math.hypot(kFirst.getCoordinateX() - vSecond.getCoordinateX(),
                                        kFirst.getCoordinateY() - vSecond.getCoordinateY());
        double tmpResSecond = Math.hypot(vSecond.getCoordinateX() - zThird.getCoordinateX(),
                                         vSecond.getCoordinateY() - zThird.getCoordinateY());
        double tmpResThird = Math.hypot(zThird.getCoordinateX() - kFirst.getCoordinateX(),
                                        zThird.getCoordinateY() - kFirst.getCoordinateY());

        double tmp = (tmpResFirst + tmpResSecond + tmpResThird) / 2;

        return Math.sqrt(tmp * (tmp - tmpResFirst) * (tmp - tmpResSecond) * (tmp - tmpResThird));
    };

    int isInside(Point<Double> pointToCheck, Point<Double> firstPoint, Point<Double> secondPoint, Point<Double> thirdPoint);

    static int isInsideTrianglePoints(Point<Double> pointToCheck, Point<Double> firstPoint,
                                      Point<Double> secondPoint, Point<Double> thirdPoint) {
        double areaTriangle = CALCULATION.calculate(firstPoint, secondPoint, thirdPoint);

        double firstAreaToCheck = CALCULATION.calculate(pointToCheck, firstPoint, secondPoint);
        double secondAreaToCheck = CALCULATION.calculate(pointToCheck, secondPoint, thirdPoint);
        double thirdAreaToCheck = CALCULATION.calculate(pointToCheck, thirdPoint, firstPoint);

        if (firstAreaToCheck == 0 || secondAreaToCheck == 0 || thirdAreaToCheck == 0)
            return 0;

        return areaTriangle == firstAreaToCheck + secondAreaToCheck + thirdAreaToCheck ? 1 : -1;
    }

}
