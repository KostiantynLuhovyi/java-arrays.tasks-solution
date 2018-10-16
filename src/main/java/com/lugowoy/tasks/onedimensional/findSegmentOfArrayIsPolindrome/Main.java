package com.lugowoy.tasks.onedimensional.findSegmentOfArrayIsPolindrome;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthArray;

import java.util.Arrays;
import java.util.Objects;

/** Created by Konstantin Lugowoy on 18.06.2017. */

public class Main {

    private static final int BOUND = 50;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<Integer> array = Array.create(new FillingArrayRandomIntegerNumbers().fill(lengthOfArray, BOUND));

        System.out.println("Original " + array);

        getPalindromeAndLength(array);

    }

    private static void getPalindromeAndLength(Array<Integer> array) {
        int count = 1;
        for (int i = 0; i < count; i++) {
            boolean isPalindrome = false;
            if ((array.getLength() - count + 1) == 1) {
                isPalindrome = true;
            } else {
                for (int j = 0; j < (array.getLength() - count + 1) / 2; j++) {
                    if (Objects.equals(array.get(i + j), array.get(i + array.getLength() - count - j))) {
                        if (j + 1 == (array.getLength() - count + 1) / 2) {
                            isPalindrome = true;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (isPalindrome) {
                Integer[] temp = Arrays.copyOfRange(array.toArray(new Integer[array.getLength()]), i, array.getLength() - count + i + 1);
                if (temp.length > 1) {
                    System.out.println(Arrays.toString(temp) + ", length is equal " + temp.length);
                    return;
                } else {
                    System.out.println();
                    System.out.println("In the array there is no segment that is a palindrome.");
                    return;
                }
            }
            if (i + 1 == count) {
                i = 0;
                count++;
            }
        }
    }

}
