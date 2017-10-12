package com.lugowoy.tasks.onedimensional.findLengthOfLongestSequenceOfElementsEqualToZero;

import com.lugowoy.helper.models.arrays.Array;

/** Created by Konstantin Lugowoy on 18.06.2017. */

@FunctionalInterface
public interface Findable<T, V> {

     T find(V v);

     static Integer findLengthOfLongestSequenceOfElementsEqualToZero(Array<Integer> array) {
         int resultCount = 0, count = 0;
         for (int i : array.getArray()) {
             if (i == 0) {
                 count++;
             } else {
                 count = 0;
             }

             resultCount = resultCount < count ? count : resultCount;

         }
         return resultCount;
     }

}
