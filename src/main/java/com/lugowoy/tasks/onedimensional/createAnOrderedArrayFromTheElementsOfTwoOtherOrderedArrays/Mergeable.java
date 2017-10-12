package com.lugowoy.tasks.onedimensional.createAnOrderedArrayFromTheElementsOfTwoOtherOrderedArrays;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.models.arrays.Array;

import java.util.Objects;

/** Created by Konstantin Lugowoy on 30.05.2017. */

@FunctionalInterface
public interface Mergeable<T> {

    T merge(T firstT, T secondT);

    static Array<Integer> mergeArrays(Array<Integer> firstArray, Array<Integer> secondArray) {
        Array<Integer> resultArray = null;

        if ((Objects.nonNull(firstArray)) && (Objects.nonNull(secondArray))) {
            if (((Objects.nonNull(firstArray.getArray())) && (firstArray.getArray().length > 0))
                    && ((Objects.nonNull(secondArray.getArray())) && (secondArray.getArray().length > 0))) {

                resultArray = new CreatorOfArrayModels<>(new FactoryOfIntegerArrayModels()).create(firstArray.getArray().length + secondArray.getArray().length);

                int indexFirstArray = 0, indexSecondArray = 0;

                for (int i = 0; i < resultArray.getArray().length; i++) {
                    if ((indexFirstArray < firstArray.getArray().length)
                            && (indexSecondArray < secondArray.getArray().length)) {
                        if (firstArray.getArray()[indexFirstArray] > secondArray.getArray()[indexSecondArray]) {
                            resultArray.getArray()[i] = secondArray.getArray()[indexSecondArray++];
                        } else {
                            resultArray.getArray()[i] = firstArray.getArray()[indexFirstArray++];
                        }
                    } else if (indexSecondArray < secondArray.getArray().length) {
                        resultArray.getArray()[i] = secondArray.getArray()[indexSecondArray++];
                    } else {
                        resultArray.getArray()[i] = firstArray.getArray()[indexFirstArray++];
                    }
                }
            } else {
                System.out.println("The array is not valid for any operations or calculations.");
            }
        } else {
            System.out.println("The array is not valid for any operations or calculations.");
        }
        return resultArray;
    }

}
