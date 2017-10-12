package com.lugowoy.tasks.onedimensional.compareTheMultiplicationModulesOfPositiveAndNegativeNumbers.multiplicate;

/** Created by Konstantin Lugowoy on 11.03.2017. */

@FunctionalInterface
public interface Multipliable<T, V> {

    T multiplication(V v);

}
