package com.lugowoy.tasks.onedimensional.determineEquilibriumBetweenWeightOfSubjects;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthArray;

/** Created by Konstantin Lugowoy on 27.05.2018. */

public class Main {

    private static final int BOUND = 100;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> integerArray = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, BOUND));

        System.out.println("The array of integer numbers : " + integerArray);

        Array<Subject> subjectArray = Array.create(new FillingArraySubjects(integerArray).fill(lengthOfArray));

        System.out.println("The array of subjects : " + subjectArray);

        Determinant determinant = Determinant::determineEquilibriumBetweenWeightOfSubjects;
        if (determinant.determine(subjectArray)) {
            System.out.println("Scales are in equilibrium.");
        } else {
            System.out.println("Scales is not in equilibrium.");
        }

    }

}
