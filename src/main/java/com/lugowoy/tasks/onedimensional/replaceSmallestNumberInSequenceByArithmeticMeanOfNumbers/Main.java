package com.lugowoy.tasks.onedimensional.replaceSmallestNumberInSequenceByArithmeticMeanOfNumbers;

import java.util.Arrays;
import java.util.Random;

/** Created by Konstantin Lugowoy on 25.03.2017. */

public class Main {

    private static final Replacement<Integer> REPLACEMENT = Replacement::replaceTheSmallestNumberInTheSequence;

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        Sequence<Integer> sequence = new Sequence<>(Arrays.stream(new int[20])
                                                          .map(operand -> RANDOM.nextInt(100))
                                                          .boxed()
                                                          .toArray(Integer[]::new));

        System.out.println("Original sequence : ");
        Arrays.stream(sequence.getSequence()).forEachOrdered(integer -> System.out.print(integer + " "));
        System.out.println();

        int resultIntegerPartOfArithmeticMeanNumberOfTheSequence = getArithmeticMeanNumbersOfTheSequence(sequence);
        System.out.printf("Arithmetic mean number of the sequence is : %d", resultIntegerPartOfArithmeticMeanNumberOfTheSequence);
        System.out.println();

        REPLACEMENT.replace(sequence, resultIntegerPartOfArithmeticMeanNumberOfTheSequence);

        System.out.println("Sequence after replacement : ");
        Arrays.stream(sequence.getSequence()).forEachOrdered(value -> System.out.print(value + " "));
        System.out.println();

    }

    private static int getArithmeticMeanNumbersOfTheSequence(Sequence<Integer> sequence) {
        double resultArithmeticMeanNumberOfTheSequence = 0;

        double sumAllNumber = 0;
        for (int i = 0; i < sequence.getSequence().length; i++) {
            sumAllNumber += sequence.getSequence()[i];
            resultArithmeticMeanNumberOfTheSequence = sumAllNumber / sequence.getSequence().length;
        }
        return (int)resultArithmeticMeanNumberOfTheSequence;
    }

}
