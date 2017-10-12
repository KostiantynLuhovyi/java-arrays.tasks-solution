package com.lugowoy.tasks.onedimensional.defineRingWithTheCenterAtTheOriginWhichContainsAllThePoints;

import com.lugowoy.helper.generating.GeneratorDataRandomDouble;
import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingDataUserInputInConsole;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 16.05.2017. */

public class Main {

    private static Reader reader = new Reader(new ReadingDataUserInputInConsole());

    public static void main(String[] args) {

        ArrayOfCoordinates<Double> arrayOfCoordinates = new ArrayOfCoordinates<>();

        System.out.println("Enter the number of points for the task : ");
        int numberOfPoints = reader.readInt();

        arrayOfCoordinates.setArrayOfCoordinates(Arrays.stream(new Double[numberOfPoints * 2])
                                                       .mapToDouble(value -> value = GeneratorDataRandomDouble.generateDouble())
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

        Determinable<Double> determinable = Determinable::determineRingWhichContainsAllCoordinatesOfPoints;
        determinable.determine(arrayOfCoordinates);

    }

}
