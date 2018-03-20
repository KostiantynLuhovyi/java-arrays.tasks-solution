package com.lugowoy.tasks.onedimensional.countApplicantsWithAssessmentIsNotAllowedForSecondExam;

import java.util.Arrays;
import java.util.Random;

/** Created by Konstantin Lugowoy on 23-Feb-17. */

public class Main {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        Applicant[] applicantsArray = Arrays.stream(new Applicant[20])
                                            .map(applicant -> new Applicant(RANDOM.nextInt(5) - 1 + 1 + 1))
                                            .toArray(Applicant[]::new);

        System.out.println("Original applicant array : ");
        Arrays.stream(applicantsArray).forEachOrdered(System.out::println);
        System.out.println();

        System.out.println("Result : ");
        Arrays.stream(applicantsArray)
              .filter(applicant -> applicant.getRating() == 1 || applicant.getRating() == 2)
              .forEachOrdered(System.out::println);
        System.out.println();

        System.out.print("The number of applicants not admitted to exam : ");
        System.out.println(Arrays.stream(applicantsArray)
                                 .filter(applicant -> applicant.getRating() == 1 || applicant.getRating() == 2)
                                 .count());
    }

}
