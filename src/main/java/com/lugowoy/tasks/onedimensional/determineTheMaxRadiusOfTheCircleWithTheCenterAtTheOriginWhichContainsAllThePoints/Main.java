package com.lugowoy.tasks.onedimensional.determineTheMaxRadiusOfTheCircleWithTheCenterAtTheOriginWhichContainsAllThePoints;

import com.lugowoy.helper.generating.GeneratorDataRandomInteger;
import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingDataUserInputInConsole;

import java.util.Arrays;

import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY;
import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY;

/** Created by Konstantin Lugowoy on 14.05.2017. */

public class Main {

    private static Reader reader = new Reader(new ReadingDataUserInputInConsole());

    public static void main(String[] args) {

        ArrayOfCoordinatesOfThePointsOfThePlane arrayOfCoordinates = new ArrayOfCoordinatesOfThePointsOfThePlane();

        System.out.println("Enter the number of points to define : ");
        int numberOfPoints = reader.readInt();

        arrayOfCoordinates.setCoordinatesOfPoints(Arrays.stream(new Integer[numberOfPoints * 2])
                                                        .mapToInt(value -> value = GeneratorDataRandomInteger.generateInt(DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY, DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY))
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
        Determinable determinable = Determinable::determineTeMaxRadius;
        System.out.printf("Maximal radius is %.2f", determinable.determine(arrayOfCoordinates));

    }

}
