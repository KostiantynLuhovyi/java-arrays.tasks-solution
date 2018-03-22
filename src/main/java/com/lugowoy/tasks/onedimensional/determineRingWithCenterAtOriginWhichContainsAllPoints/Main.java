package com.lugowoy.tasks.onedimensional.determineRingWithCenterAtOriginWhichContainsAllPoints;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 16.05.2017. */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        ArrayOfCoordinates<Double> arrayOfCoordinates = new ArrayOfCoordinates<>();

        System.out.println("Enter the number of points for the task : ");
        int numberOfPoints = READER.readInt();

        arrayOfCoordinates.setArrayOfCoordinates(Arrays.stream(new Double[numberOfPoints * 2])
                                                       .mapToDouble(value -> value = GeneratorRandomNumber.generateDouble())
                                                       .boxed()
                                                       .toArray(Double[]::new));


        System.out.println("Coordinates of points : ");
        int countLn = 0;
        for (int i = 0; i < arrayOfCoordinates.getArrayOfCoordinates().length; i++) {
            System.out.print(arrayOfCoordinates.getArrayOfCoordinates()[i] + " ");
            countLn++;
            if (countLn == 2) {
                System.out.println();
                countLn = 0;
            }
        }

        Determinant<Double> determinant = Determinant::determineRingWhichContainsAllCoordinatesOfPoints;
        determinant.determine(arrayOfCoordinates);

    }

}
