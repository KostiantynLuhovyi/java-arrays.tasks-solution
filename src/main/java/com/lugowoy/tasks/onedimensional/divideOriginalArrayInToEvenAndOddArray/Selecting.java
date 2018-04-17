package com.lugowoy.tasks.onedimensional.divideOriginalArrayInToEvenAndOddArray;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.other.ArrayChecker.checkArrayNonNull;
import static com.lugowoy.helper.other.ArrayChecker.checkLengthOfArrayIsGreaterZero;

/** Created by Konstantin Lugowoy on 16.03.2017. */

public interface Selecting<T> {

    int STATUS_EVEN_NUMBERS = 1;
    int STATUS_ODD_NUMBERS = 0;

    T select(T t, int statusNumbers);

    static Array<Integer> selectArray(Array<Integer> array, int statusNumbers) {
        Array<Integer> tmpArray = FactoryArray.getFactoryArray(new CreatorArrayNumbers<Integer>()).create(0);
        try {
            if (checkArrayNonNull(array)) {
                if (checkLengthOfArrayIsGreaterZero(array.getLength())) {
                    if (statusNumbers == STATUS_EVEN_NUMBERS) {
                        for (int i = 0; i < array.getLength(); i++) {
                            if (array.get(i) != null) {
                                if (array.get(i) % 2 == 0) {
                                    tmpArray.add(array.get(i));
                                }
                            }
                        }
                    } else if (statusNumbers == STATUS_ODD_NUMBERS) {
                        for (int i = 0; i < array.getLength(); i++) {
                            if (array.get(i) != null) {
                                if (array.get(i) % 2 != 0) {
                                    tmpArray.add(array.get(i));
                                }
                            }
                        }
                    }
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        return tmpArray;
    }

}
