package com.lugowoy.tasks.onedimensional.changeSequenceByMultiplyingElementsBySquareOfMinAndMaxNumbersByRule;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthArray;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.NEGATIVE_INTEGER_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;

/** Created by Konstantin Lugowoy on 25.03.2017. */

public class Main {

    private static final Changing<Array<Integer>, Integer> CHANGING = Changing::changeSequenceByMultiplyingElementsBySquareOfMinAndMaxNumberByRule;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> array = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, NEGATIVE_INTEGER_BOUND,
                                                                                                       POSITIVE_INTEGER_BOUND));

        System.out.println("Original sequence : " + array);
        System.out.println();

        int squareMinNumberInTheSequence = getSquareMinNumberInTheSequence(array, Determinant::determineMinNumber);

        int squareMaxNumberInTheSequence = getSquareMaxNumberInTheSequence(array, Determinant::determineMaxNumber);

        CHANGING.change(array, squareMinNumberInTheSequence, squareMaxNumberInTheSequence);

        System.out.println();
        System.out.println("Result sequence after changing : " + array);
        System.out.println();

    }

    private static int getSquareMaxNumberInTheSequence(Array<Integer> array, Determinant<Integer> determinant) {
        int squareMaxNumberInTheSequence = (int) Math.pow(determinant.determine(array), 2);
        System.out.println("Square max number in the array is " + squareMaxNumberInTheSequence + " .");
        return squareMaxNumberInTheSequence;
    }

    private static int getSquareMinNumberInTheSequence(Array<Integer> array, Determinant<Integer> determinant) {
        int squareMinNumberInTheSequence = (int) Math.pow(determinant.determine(array), 2);
        System.out.println("Square min number in the array is " + squareMinNumberInTheSequence + " .");
        return squareMinNumberInTheSequence;
    }

}
