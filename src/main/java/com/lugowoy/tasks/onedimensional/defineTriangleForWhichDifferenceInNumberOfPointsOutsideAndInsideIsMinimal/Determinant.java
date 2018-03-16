package com.lugowoy.tasks.onedimensional.defineTriangleForWhichDifferenceInNumberOfPointsOutsideAndInsideIsMinimal;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayPoints;
import com.lugowoy.helper.filling.array.points.FillingArrayOfPointsWithCoordinatesRandomDoubleNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;

import static com.lugowoy.helper.other.ArrayChecker.checkArrayNonNull;
import static com.lugowoy.helper.other.ArrayChecker.checkLengthOfArrayIsGreaterZero;

/** Created by Konstantin Lugowoy on 03.07.2017. */

@FunctionalInterface
public interface Determinant<T> {

    CheckInsidePoint CHECK_INSIDE_POINT = CheckInsidePoint::isInsideTrianglePoints;

    T define(T t);

    static Array<Point<Double>> defineTriangle(Array<Point<Double>> pointArray) {
        Array<Point<Double>> resultPointOfTriangle = FactoryArray.getFactoryArray(new CreatorArrayPoints<Double>()).create(
                                                                                      new FillingArrayOfPointsWithCoordinatesRandomDoubleNumbers().fill(3));
        if (checkArrayNonNull(pointArray)) {
            if (checkArrayNonNull(pointArray.getArray()) && checkLengthOfArrayIsGreaterZero(pointArray.getLength())) {
                int lengthArray = pointArray.getLength();
                for (int i = 0; i < lengthArray; i++) {
                    for (int j = i + 1; j < lengthArray; j++) {
                        for (int k = j + 1; k < lengthArray; k++) {
                            int countLength = 0;

                            for (int l = 0; l < lengthArray; l++) {

                                if (i == l || j == l || k == l) {
                                    continue;
                                }

                                countLength += CHECK_INSIDE_POINT.isInside(pointArray.get(l),
                                        pointArray.get(i), pointArray.get(j), pointArray.get(k));

                            }

                            countLength = Math.abs(countLength);

                            if (countLength < lengthArray) {
                                lengthArray = countLength;
                                resultPointOfTriangle.set(0, pointArray.get(i));
                                resultPointOfTriangle.set(1, pointArray.get(j));
                                resultPointOfTriangle.set(2, pointArray.get(k));
                            }

                        }
                    }
                }


            } else {
                System.out.println("The array is not valid for any operations or calculations.");
            }
        } else {
            System.out.println("The array is not valid for any operations or calculations.");
        }
        return resultPointOfTriangle;
    }

}
