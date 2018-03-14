package com.lugowoy.tasks.onedimensional.changeSequenceByMultiplyingElementsBySquareOfMinAndMaxNumbersByRule;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_NEGATIVE_BOUND;
import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_INTEGER_POSITIVE_BOUND;

/** Created by Konstantin Lugowoy on 25.03.2017. */

public class Main {

    private static final Changer<Array<Integer>, Integer> CHANGER =
                                            Changer::changeSequenceByMultiplyingElementsBySquareOfMinAndMaxNumberByRule;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<Integer> array = FactoryArray.getFactoryArray(new CreatorArrayNumbers<Integer>()).create(
                                                                new FillingArrayRandomIntegerNumbers().fill(lengthArray,
                                                                                                            DEFAULT_INTEGER_NEGATIVE_BOUND,
                                                                                                            DEFAULT_INTEGER_POSITIVE_BOUND));

        System.out.println("Original sequence : " + array);
        System.out.println();

        int squareMinNumberInTheSequence = getSquareMinNumberInTheSequence(array, Finder::findMinNumber);

        int squareMaxNumberInTheSequence = getSquareMaxNumberInTheSequence(array, Finder::findMaxNumber);

        CHANGER.change(array, squareMinNumberInTheSequence, squareMaxNumberInTheSequence);

        System.out.println();
        System.out.println("Result sequence after changing : " + array);
        System.out.println();

    }

    private static int getSquareMaxNumberInTheSequence(Array<Integer> array, Finder<Integer> finder) {
        int squareMaxNumberInTheSequence = (int) Math.pow(finder.find(array), 2);
        System.out.println("Square max number in the array is " + squareMaxNumberInTheSequence + " .");
        return squareMaxNumberInTheSequence;
    }

    private static int getSquareMinNumberInTheSequence(Array<Integer> array, Finder<Integer> finder) {
        int squareMinNumberInTheSequence = (int) Math.pow(finder.find(array), 2);
        System.out.println("Square min number in the array is " + squareMinNumberInTheSequence + " .");
        return squareMinNumberInTheSequence;
    }

}
