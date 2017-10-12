package com.lugowoy.tasks.onedimensional.changeSequenceByMultiplyingTheElementsByTheSquareOfTheMinAndMaxNumbersByRule;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.filling.FillingArrayIntegerRandomNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.DeterminatorSizeOfArray;

import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY;
import static com.lugowoy.helper.other.DefaultNumber.DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY;

/** Created by Konstantin Lugowoy on 25.03.2017. */

public class Main {

    private static final Changeable<Array<Integer>, Integer> CHANGEABLE = Changeable::changeSequenceByMultiplyingTheElementsByTheSquareOfTheMinAndMaxNumberByRule;

    public static void main(String[] args) {

        int sizeArray = DeterminatorSizeOfArray.determineSizeOfArray();

        Array<Integer> array = new CreatorOfArrayModels<>(
                                    new FactoryOfIntegerArrayModels()).create(
                new FillingArrayIntegerRandomNumbers().fill(sizeArray, DEFAULT_MIN_INTEGER_ELEMENT_IN_ARRAY, DEFAULT_MAX_INTEGER_ELEMENT_IN_ARRAY));

        System.out.println("Original sequence : " + array);
        System.out.println();

        int squareMinNumberInTheSequence = getSquareMinNumberInTheSequence(array, Findable::findMinNumber);

        int squareMaxNumberInTheSequence = getSquareMaxNumberInTheSequence(array, Findable::findMaxNumber);

        CHANGEABLE.change(array, squareMinNumberInTheSequence, squareMaxNumberInTheSequence);

        System.out.println();
        System.out.println("Result sequence after changing : " + array);
        System.out.println();

    }

    private static int getSquareMaxNumberInTheSequence(Array<Integer> array, Findable<Integer> findable) {
        int squareMaxNumberInTheSequence = (int) Math.pow(findable.find(array), 2);
        System.out.println("Square max number in the array is " + squareMaxNumberInTheSequence + " .");

        return squareMaxNumberInTheSequence;
    }

    private static int getSquareMinNumberInTheSequence(Array<Integer> array, Findable<Integer> findable) {
        int squareMinNumberInTheSequence = (int) Math.pow(findable.find(array), 2);
        System.out.println("Square min number in the array is " + squareMinNumberInTheSequence + " .");

        return squareMinNumberInTheSequence;
    }

}
