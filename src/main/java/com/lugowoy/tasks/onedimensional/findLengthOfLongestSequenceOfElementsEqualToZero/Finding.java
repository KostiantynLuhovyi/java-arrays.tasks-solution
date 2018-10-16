package com.lugowoy.tasks.onedimensional.findLengthOfLongestSequenceOfElementsEqualToZero;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;

/** Created by Konstantin Lugowoy on 18.06.2017. */

@FunctionalInterface
public interface Finding<T, V> {

     T find(V v);

     static Integer findLengthOfLongestSequenceOfElementsEqualToZero(Array<Integer> array) {
         int resultCount = 0, count = 0;
         if (CheckerArray.checkArrayNonNull(array)) {
             if (CheckerArray.checkLengthOfArrayIsGreaterZero(array.getLength())) {
                 for (int i = 0; i < array.getLength(); i++) {
                     if (array.get(i) == 0) {
                         count++;
                     } else {
                         count = 0;
                     }
                     resultCount = resultCount < count ? count : resultCount;
                     }
                 }
             }
         return resultCount;
     }

}
