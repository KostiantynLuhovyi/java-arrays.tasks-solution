package com.lugowoy.tasks.onedimensional.determineEquilibriumBetweenWeightOfSubjects;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.FillingArraySubjects;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;
import com.lugowoy.helper.factory.CreatorArraySubjects;

/** Created by Konstantin Lugowoy on 27.05.2018. */

public class Main {

    private static final int BOUND = 100;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<Integer> integerArray = FactoryArray.getFactoryArray(new CreatorArrayNumbers<Integer>()).create(
                                                                        new FillingArrayRandomIntegerNumbers().fill(lengthArray, BOUND));

        System.out.println("The array of integer numbers : " + integerArray);

        Array<Subject> subjectArray = FactoryArray.getFactoryArray(new CreatorArraySubjects()).create(
                                                                        new FillingArraySubjects(integerArray).fill(lengthArray));

        System.out.println("The array of subjects : " + subjectArray);

        Determinant determinant = Determinant::determineEquilibriumBetweenWeightOfSubjects;
        if (determinant.determine(subjectArray)) {
            System.out.println("Scales are in equilibrium.");
        } else {
            System.out.println("Scales is not in equilibrium.");
        }

    }

}
