package com.lugowoy.tasks.onedimensional.determineWhetherItIsPossibleToSelectContiguousElementsInOneOfArraysByCondition;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.models.arrays.Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static com.lugowoy.helper.other.ArrayChecker.checkArrayNonNull;
import static com.lugowoy.helper.other.ArrayChecker.checkLengthOfArrayIsGreaterZero;

/** Created by Konstantin Lugowoy on 24.06.2017. */

@FunctionalInterface
public interface Determinant<T> {

    List<T> determine(T firstT, T secondT);

    static List<Array<Integer>> determineWhetherItIsPossibleToSelectContiguousElements(Array<Integer> firstArray,
                                                                                       Array<Integer> secondArray) {
        List<Array<Integer>> resultList = new LinkedList<>();
        int n = 0, k = firstArray.getLength();

        try {
            if (checkArrayNonNull(firstArray) && checkArrayNonNull(secondArray)) {
                if ((checkArrayNonNull(firstArray.getArray())
                                                       && checkArrayNonNull(secondArray.getArray()))
                        && (checkLengthOfArrayIsGreaterZero(firstArray.getLength())
                                                       && checkLengthOfArrayIsGreaterZero(secondArray.getLength()))) {
                    while (n + 1 < k) {
                        for (int i = 0; i < secondArray.getLength() - (k - 1 - n); i++) {
                            Array<Integer> tempResultArray = FactoryArray.getFactoryArray(
                                                                new CreatorArrayNumbers<Integer>()).create(
                                                                        Arrays.copyOfRange(firstArray.getArray(), n, k));
                            if (Arrays.equals(tempResultArray.getArray(), Arrays.copyOfRange(secondArray.getArray(), i, k - n + i))) {
                                resultList.add(tempResultArray);
                            }
                        }
                        if (n + 1 == --k) {
                            n++;
                            k = firstArray.getLength();
                        }
                    }
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        return resultList;
    }

}
