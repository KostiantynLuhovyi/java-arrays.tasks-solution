package com.lugowoy.tasks.onedimensional.determineMaxRadiusOfCircleWithCenterAtOriginWhichContainsAllPoints;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import java.util.Arrays;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.NEGATIVE_INTEGER_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;

/** Created by Konstantin Lugowoy on 14.05.2017. */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    private static final Determinant DETERMINANT = Determinant::determineTeMaxRadius;

    public static void main(String[] args) {

        ArrayOfCoordinates arrayOfCoordinates = new ArrayOfCoordinates();

        System.out.println("Enter the number of points to define : ");
        int numberOfPoints = READER.readInt();

        arrayOfCoordinates.setCoordinatesOfPoints(Arrays.stream(new Integer[numberOfPoints * 2])
                                                        .mapToInt(value -> value = GeneratorRandomNumber.generateInt(NEGATIVE_INTEGER_BOUND,
                                                                                                                     POSITIVE_INTEGER_BOUND))
                                                        .toArray());

        System.out.println("Coordinates of points : ");
        int countLn = 0;
        for (int i = 0; i < arrayOfCoordinates.getCoordinatesOfPoints().length; i++) {
            System.out.print(arrayOfCoordinates.getCoordinatesOfPoints()[i] + " ");
            countLn++;
            if (countLn == 2) {
                System.out.println();
                countLn = 0;
            }
        }

        System.out.println();
        System.out.printf("Maximal radius is %.2f", DETERMINANT.determine(arrayOfCoordinates));

    }

}
