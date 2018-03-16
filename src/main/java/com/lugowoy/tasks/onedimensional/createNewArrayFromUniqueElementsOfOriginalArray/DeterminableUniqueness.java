package com.lugowoy.tasks.onedimensional.createNewArrayFromUniqueElementsOfOriginalArray;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.models.arrays.Array;

/** Created by Konstantin Lugowoy on 29.05.2017. */

@FunctionalInterface
public interface DeterminableUniqueness {

    int CRITICAL_COUNT_UNIQUE = 2;

    Array<Integer> determineUniqueness(Array<Integer> array);

    static Array<Integer> determineTheUniqueElementsOfTheOriginalArray(Array<Integer> array) {
        int countUnique = 0;
        Array<Integer> tmpArray = FactoryArray.getFactoryArray(new CreatorArrayNumbers<Integer>()).create(0);
        for (int i = 0; i < array.getLength(); i++) {
            for (int j = 0; j < array.getLength(); j++) {
                if ((array.get(i).equals(array.get(j)))) {
                    countUnique++;
                }
            }
            if (countUnique < CRITICAL_COUNT_UNIQUE) {
                tmpArray.add(array.get(i));
            }
            countUnique = 0;
        }
        return tmpArray;
    }

}
