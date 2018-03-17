package com.lugowoy.tasks.onedimensional.replaceTheArrayNumbersOfLargerZ;

/**Created by Konstantin Lugowoy on 13-Feb-17.*/

@FunctionalInterface
public interface Replacement<T, V> {

    void replace(T numbersSequence, V v);

}
