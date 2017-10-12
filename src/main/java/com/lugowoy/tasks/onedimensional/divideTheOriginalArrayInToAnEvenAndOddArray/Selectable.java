package com.lugowoy.tasks.onedimensional.divideTheOriginalArrayInToAnEvenAndOddArray;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.models.arrays.Array;

import java.util.ArrayList;
import java.util.Objects;

/** Created by Konstantin Lugowoy on 16.03.2017. */

public interface Selectable<T> {

    int STATUS_EVEN_NUMBERS = 1;
    int STATUS_ODD_NUMBERS = 0;

    T select(T t, int statusNumbers);

    static Array<Integer> selectableArray(Array<Integer> array, int statusNumbers) {
        ArrayList<Integer> integerList = new ArrayList<>(0);
        if (Objects.nonNull(array)) {
            if (statusNumbers == STATUS_EVEN_NUMBERS) {
                for (Integer integer : array.getArray()) {
                    if (integer != null) {
                        if (integer % 2 == 0) {
                            integerList.add(integer);
                        }
                    }
                }
            } else if (statusNumbers == STATUS_ODD_NUMBERS) {
                for (Integer integer : array.getArray()) {
                    if (integer != null) {
                        if (integer % 2 != 0) {
                            integerList.add(integer);
                        }
                    }
                }
            }
        }
        return new CreatorOfArrayModels<>(new FactoryOfIntegerArrayModels()).create(integerList.toArray(new Integer[integerList.size()]));
    }

}
