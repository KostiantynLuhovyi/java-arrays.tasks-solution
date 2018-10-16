package com.lugowoy.tasks.onedimensional.determineMostRepeatedElementInArray;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;
import com.lugowoy.helper.other.LengthArray;

/** Created by Konstantin Lugowoy on 22.03.2017. */

public class Main {

    private static final int BOUND = 50;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> array = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, BOUND));

        System.out.println("Original array : " + array);
        System.out.println();

        DETERMINANT.determine(array);

    }

    private static final Determinant<Integer> DETERMINANT = array -> {
        int count, countMax = 0, value = 1, num = 0;
        if (CheckerArray.checkArrayNonNull(array)) {
            if (array.getLength() > 2) {
                for (int i = 0; i < array.getLength(); i++) {
                    count = 1;
                    for (int j = i + 1; j < array.getLength(); j++) {
                        if (array.get(i).equals(array.get(j))) {
                            value = array.get(j);
                            count++;
                        } else if (count > countMax) {
                            countMax = count;
                            if (value <= array.get(i)) {
                                num = i;
                            }
                        }
                    }
                }
            }
        }
        if (countMax == 1) {
            System.out.println("No repetitive elements in the array.");
        } else {
            System.out.println("Element " + array.get(num) + ", repeated " + countMax);
        }
    };

}
