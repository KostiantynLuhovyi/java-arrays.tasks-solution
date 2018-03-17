package com.lugowoy.tasks.onedimensional.specifySetOfTrianglesWithVerticesAtGivenPointsThatIntersectWithCircle;

import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.other.ArrayChecker;

import static com.lugowoy.helper.other.ArrayChecker.*;
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/** Created by Konstantin Lugowoy on 03.07.2017. */

@FunctionalInterface
public interface TrigonometricDeterminant<T, V> {

    void determine(T t, V v);

    static void determineSetOfTrianglesWithVerticesAtGivenPointsThatIntersectWithCircle(Array<Point<Integer>> pointArray, double radius) {
        try {
            if (checkArrayNonNull(pointArray)) {
                if (checkArrayNonNull(pointArray.getArray()) && checkLengthOfArrayIsGreaterZero(pointArray.getLength())) {
                    int countTriangle = 0;
                    for (int i = 0; i < pointArray.getLength() - 2; i++) {
                        for (int j = i + 1; j < pointArray.getLength() - 1; j++) {
                            for (int k = j + 1; k < pointArray.getLength(); k++) {
                                if (((sqrt(pow(pointArray.get(i).getCoordinateX(), 2) + pow(pointArray.get(i).getCoordinateY(), 2))) <= radius)
                                      && ((sqrt(pow(pointArray.get(j).getCoordinateX(), 2) + pow(pointArray.get(i).getCoordinateY(), 2))) <= radius)
                                      && ((sqrt(pow(pointArray.get(k).getCoordinateX(), 2) + pow(pointArray.get(k).getCoordinateY(), 2)) <= radius))) {
                                    countTriangle++;
                                    System.out.print(pointArray.get(i) + "; ");
                                    System.out.print(pointArray.get(j) + "; ");
                                    System.out.print(pointArray.get(k) + "; ");
                                    System.out.print(" are the vertices of a triangle inscribed or intersecting with a circle.");
                                    System.out.println();
                                }
                            }
                        }
                    }
                    System.out.printf("The total number of triangles inscribed and intersecting with the circle is %d .", countTriangle);
                }
            }


        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
