package com.lugowoy.tasks.onedimensional.createNewArrayFromTheUniqueElementsOfTheOriginalArray;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerArrayModels;
import com.lugowoy.helper.models.arrays.Array;

import java.util.ArrayList;
import java.util.List;

/** Created by Konstantin Lugowoy on 29.05.2017. */

@FunctionalInterface
public interface DeterminableUniqueness {

    int CRITICAL_COUNT_UNIQUE = 2;

    Array<Integer> determineUniqueness(Array<Integer> array);

    static Array<Integer> determineTheUniqueElementsOfTheOriginalArray(Array<Integer> array) {
        int countUnique = 0;
        List<Integer> integerList = new ArrayList<>(0);
        for (int i = 0; i < array.getArray().length; i++) {
            for (int j = 0; j < array.getArray().length; j++) {
                if ((array.getArray()[i].equals(array.getArray()[j]))) {
                    countUnique++;
                }
            }
            if (countUnique < CRITICAL_COUNT_UNIQUE) {
                integerList.add(array.getArray()[i]);
            }
            countUnique = 0;
        }
        return new CreatorOfArrayModels<>(new FactoryOfIntegerArrayModels()).create(integerList.stream().toArray(Integer[]::new));
    }

}
