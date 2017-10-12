package com.lugowoy.tasks.onedimensional.determineWhetherItIsPossibleToSelectContiguousElementsInOneOfArraysByCondition;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.models.arrays.Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/** Created by Konstantin Lugowoy on 24.06.2017. */

@FunctionalInterface
public interface Determine<T> {

    List<T> determine(T firstT, T secondT);

    static List<Array<Integer>> determineWhetherItIsPossibleToSelectContiguousElements(Array<Integer> firstArray, Array<Integer> secondArray) {
        List<Array<Integer>> resultList = new LinkedList<>();
        int n = 0, k = firstArray.getArray().length;

        while (n + 1 < k) {
            for (int i = 0; i < secondArray.getArray().length - (k - 1 - n); i++) {
                Array<Integer> tempResultArray = new CreatorOfArrayModels<>(new FactoryOfIntegerArrayModels()).create(Arrays.copyOfRange(firstArray.getArray(), n, k));
                if (Arrays.equals(tempResultArray.getArray(), Arrays.copyOfRange(secondArray.getArray(), i, k - n + i))){
                    resultList.add(tempResultArray);
                }
            }
            if (n  + 1 == --k) {
                n++;
                k = firstArray.getArray().length;
            }
        }
        return resultList;
    }

}
