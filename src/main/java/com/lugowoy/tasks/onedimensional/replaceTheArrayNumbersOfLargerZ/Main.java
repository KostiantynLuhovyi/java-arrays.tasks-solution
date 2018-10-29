package com.lugowoy.tasks.onedimensional.replaceTheArrayNumbersOfLargerZ;

import com.lugowoy.helper.filling.DefaultValuesForFilling;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.other.LengthArray;

import java.util.Arrays;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.NEGATIVE_INTEGER_BOUND;
import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;

/**Created by Konstantin Lugowoy on 13-Feb-17.*/

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Numbers numbersSequence = new Numbers();
        numbersSequence.setNumbers(Arrays.stream(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, NEGATIVE_INTEGER_BOUND, POSITIVE_INTEGER_BOUND))
                                         .mapToInt(Integer::intValue)
                                         .toArray());

        System.out.println("Enter number of replace : ");
        int numberToReplace = READER.readInt();

        System.out.println("Original array : ");
        Arrays.stream(numbersSequence.getNumbers()).forEachOrdered(value -> System.out.print(value + " "));
        System.out.println();

        Replacement<Numbers, Integer> numbersReplacement = (Numbers numbers, Integer numberToExchange) -> {
            int countToReplace = 0;
            for (int i = 0; i < numbers.getNumbers().length; i++) {
                if (numbers.getNumbers()[i] > numberToExchange) {
                    numbers.getNumbers()[i] = numberToExchange;
                    countToReplace++;
                }
            }
            System.out.print("Count number of replacements : " + countToReplace);
        };

        numbersReplacement.replace(numbersSequence, numberToReplace);

        System.out.println();
        System.out.println("Result replace : ");
        Arrays.stream(numbersSequence.getNumbers()).forEachOrdered(value -> System.out.print(value + " "));

    }

}
