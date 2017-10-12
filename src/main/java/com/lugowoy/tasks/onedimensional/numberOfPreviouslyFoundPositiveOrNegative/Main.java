package com.lugowoy.tasks.onedimensional.numberOfPreviouslyFoundPositiveOrNegative;

import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

import java.util.Arrays;

import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY;
import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY;

/**Created by Konstantin Lugowoy on 12-Feb-17.*/

public class Main {

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        SequenceOfIntegers sequence = new SequenceOfIntegers();
        sequence.setSequenceOfIntegers(Arrays.stream(new FillingArrayIntegerRandomNumbers().fill(
                sizeArray, DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY, DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY)).mapToInt(Integer::intValue).toArray());

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
