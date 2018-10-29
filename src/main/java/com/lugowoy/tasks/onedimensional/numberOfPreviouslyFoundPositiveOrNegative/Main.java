package com.lugowoy.tasks.onedimensional.numberOfPreviouslyFoundPositiveOrNegative;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.other.LengthArray;

import java.util.Arrays;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.NEGATIVE_INTEGER_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;

/**Created by Konstantin Lugowoy on 12-Feb-17.*/

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        SequenceOfIntegers sequence = new SequenceOfIntegers();
        sequence.setSequenceOfIntegers(Arrays.stream(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, NEGATIVE_INTEGER_BOUND,
                                                                                                                POSITIVE_INTEGER_BOUND))
                                             .mapToInt(Integer::intValue)
                                             .toArray());

        System.out.println("The sequence of integers to determine a sign of the number is the first in the sequence : ");
        Arrays.stream(sequence.getSequenceOfIntegers()).forEach(value -> System.out.print(value + " "));

        System.out.println();

        int firstElementInRheSequence = Arrays.stream(sequence.getSequenceOfIntegers()).findFirst().orElse(0);

        if (firstElementInRheSequence > 0) {
            System.out.println("The first element of the sequence positive.");
        } else if (firstElementInRheSequence < 0) {
            System.out.println("The first element of the sequence negative.");
        } else {
            System.out.println("The first element of the sequence is equal : 0.");
        }

    }

}
