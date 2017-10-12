package com.lugowoy.tasks.onedimensional.defineTriangleForWhichDifferenceInNumberOfPointsOutsideAndInsideIsMinimal;


import com.lugowoy.helper.calculating.CalculableOnTheThreeVariables;
import com.lugowoy.helper.models.points.Point;

/** Created by Konstantin Lugowoy on 08.07.2017. */

@FunctionalInterface
public interface CheckInsidablePoint {

    CalculableOnTheThreeVariables<Double, Point<Double>, Point<Double>, Point<Double>> CALCULABLE_AREA_TRIANGLE = (kFirst, vSecond, zThird) -> {
        double tmpResFirst = Math.hypot(kFirst.getCoordinateX() - vSecond.getCoordinateX(), kFirst.getCoordinateY() - vSecond.getCoordinateY());
        double tmpResSecond = Math.hypot(vSecond.getCoordinateX() - zThird.getCoordinateX(), vSecond.getCoordinateY() - zThird.getCoordinateY());
        double tmpResThird = Math.hypot(zThird.getCoordinateX() - kFirst.getCoordinateX(), zThird.getCoordinateY() - kFirst.getCoordinateY());

        double tmp = (tmpResFirst + tmpResSecond + tmpResThird) / 2;

        return Math.sqrt(tmp * (tmp - tmpResFirst) * (tmp - tmpResSecond) * (tmp - tmpResThird));
    };

    int isInside(Point<Double> pointToCheck, Point<Double> firstPoint, Point<Double> secondPoint, Point<Double> thirdPoint);

    static int isInsideTrianglePoints(Point<Double> pointToCheck, Point<Double> firstPoint, Point<Double> secondPoint, Point<Double> thirdPoint) {
        double areaTriangle = CALCULABLE_AREA_TRIANGLE.calculate(firstPoint, secondPoint, thirdPoint);

        double firstAreaToCheck = CALCULABLE_AREA_TRIANGLE.calculate(pointToCheck, firstPoint, secondPoint);
        double secondAreaToCheck = CALCULABLE_AREA_TRIANGLE.calculate(pointToCheck, secondPoint, thirdPoint);
        double thirdAreaToCheck = CALCULABLE_AREA_TRIANGLE.calculate(pointToCheck, thirdPoint, firstPoint);

        if (firstAreaToCheck == 0 || secondAreaToCheck == 0 || thirdAreaToCheck == 0)
            return 0;

        return areaTriangle == firstAreaToCheck + secondAreaToCheck + thirdAreaToCheck ? 1 : -1;
    }

}
