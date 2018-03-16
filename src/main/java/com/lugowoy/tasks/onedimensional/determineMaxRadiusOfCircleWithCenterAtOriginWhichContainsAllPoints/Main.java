package com.lugowoy.tasks.onedimensional.determineMaxRadiusOfCircleWithCenterAtOriginWhichContainsAllPoints;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import java.util.Arrays;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_NEGATIVE_BOUND;
import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_POSITIVE_BOUND;

/** Created by Konstantin Lugowoy on 14.05.2017. */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        ArrayOfCoordinates arrayOfCoordinates = new ArrayOfCoordinates();

        System.out.println("Enter the number of points to define : ");
        int numberOfPoints = READER.readInt();

        arrayOfCoordinates.setCoordinatesOfPoints(Arrays.stream(new Integer[numberOfPoints * 2])
                                                        .mapToInt(value -> value = GeneratorRandomNumber.generateInt(DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                                                     DEFAULT_INTEGER_POSITIVE_BOUND))
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
        Determinant determinable = Determinant::determineTeMaxRadius;
        System.out.printf("Maximal radius is %.2f", determinable.determine(arrayOfCoordinates));

    }

}
