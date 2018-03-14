package com.lugowoy.tasks.onedimensional.calculateSumOfMaxAndMinElementOfThisParticularSequence;

/** Created by Konstantin Lugowoy on 01.03.2017. */

@FunctionalInterface
public interface Finding<T, V> {

    V find(T t);

}
