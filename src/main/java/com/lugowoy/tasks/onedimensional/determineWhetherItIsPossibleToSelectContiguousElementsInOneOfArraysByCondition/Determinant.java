package com.lugowoy.tasks.onedimensional.determineWhetherItIsPossibleToSelectContiguousElementsInOneOfArraysByCondition;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/** Created by Konstantin Lugowoy on 24.06.2017. */

@FunctionalInterface
public interface Determinant<T> {

    List<T> determine(T firstT, T secondT);

    static List<Array<Integer>> determineWhetherItIsPossibleToSelectContiguousElements(Array<Integer> firstArray, Array<Integer> secondArray) {
        List<Array<Integer>> resultList = new LinkedList<>();
        int n = 0, k = firstArray.getLength();
        if (CheckerArray.checkArrayNonNull(firstArray) && CheckerArray.checkArrayNonNull(secondArray)) {
            if (CheckerArray.checkLengthOfArrayIsGreaterZero(firstArray.getLength())
                    && CheckerArray.checkLengthOfArrayIsGreaterZero(secondArray.getLength())) {
                while (n + 1 < k) {
                    for (int i = 0; i < secondArray.getLength() - (k - 1 - n); i++) {
                        Array<Integer> tempResultArray = Array.create(Arrays.copyOfRange(firstArray.toArray(new Integer[firstArray.getLength()]), n, k));
                        if (Arrays.equals(tempResultArray.toArray(), Arrays.copyOfRange(secondArray.toArray(), i, k - n + i))) {
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
        return resultList;
    }

}
