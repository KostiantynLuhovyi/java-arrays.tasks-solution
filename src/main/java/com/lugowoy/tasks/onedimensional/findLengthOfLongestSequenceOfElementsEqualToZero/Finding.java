package com.lugowoy.tasks.onedimensional.findLengthOfLongestSequenceOfElementsEqualToZero;

import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.other.ArrayChecker.checkArrayNonNull;
import static com.lugowoy.helper.other.ArrayChecker.checkLengthOfArrayIsGreaterZero;

/** Created by Konstantin Lugowoy on 18.06.2017. */

@FunctionalInterface
public interface Finding<T, V> {

     T find(V v);

     static Integer findLengthOfLongestSequenceOfElementsEqualToZero(Array<Integer> array) {
         int resultCount = 0, count = 0;
         try {
             if (checkArrayNonNull(array)) {
                 if (checkLengthOfArrayIsGreaterZero(array.getLength())) {
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
         } catch (IllegalArgumentException ex) {
             System.err.println(ex.getMessage());
         }
         return resultCount;
     }

}
