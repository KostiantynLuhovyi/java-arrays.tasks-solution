package com.lugowoy.tasks.onedimensional.createOrderedArrayFromElementsOfTwoOtherOrderedArrays;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.other.ArrayChecker.checkArrayNonNull;
import static com.lugowoy.helper.other.ArrayChecker.checkLengthOfArrayIsGreaterZero;

/** Created by Konstantin Lugowoy on 30.05.2017. */

@FunctionalInterface
public interface Merging<T> {

    T merge(T firstT, T secondT);

    static Array<Integer> mergeArrays(Array<Integer> firstArray, Array<Integer> secondArray) {
        Array<Integer> resultArray = null;

        if (checkArrayNonNull(firstArray) && checkArrayNonNull(secondArray)) {
            if ((checkArrayNonNull(firstArray.getArray()) && checkLengthOfArrayIsGreaterZero(firstArray.getLength()))
                    && (checkArrayNonNull(secondArray.getArray()) && checkLengthOfArrayIsGreaterZero(secondArray.getLength()))) {

                resultArray = FactoryArray.getFactoryArray(new CreatorArrayNumbers<Integer>()).create(firstArray.getLength()
                                                                                                    + secondArray.getLength());

                int indexFirstArray = 0, indexSecondArray = 0;

                for (int i = 0; i < resultArray.getLength(); i++) {
                    if ((indexFirstArray < firstArray.getLength())
                            && (indexSecondArray < secondArray.getLength())) {
                        if (firstArray.get(indexFirstArray) > secondArray.get(indexSecondArray)) {
                            resultArray.set(i, secondArray.get(indexSecondArray++));
                        } else {
                            resultArray.set(i, firstArray.get(indexFirstArray++));
                        }
                    } else if (indexSecondArray < secondArray.getLength()) {
                        resultArray.set(i, secondArray.get(indexSecondArray++));
                    } else {
                        resultArray.set(i, firstArray.get(indexFirstArray++));
                    }
                }
            }
        }
        return resultArray;
    }

}
