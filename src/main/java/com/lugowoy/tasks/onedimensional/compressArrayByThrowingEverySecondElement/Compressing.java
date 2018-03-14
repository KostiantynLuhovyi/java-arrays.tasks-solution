package com.lugowoy.tasks.onedimensional.compressArrayByThrowingEverySecondElement;

/** Created by Konstantin Lugowoy on 13.03.2017. */

@FunctionalInterface
public interface Compressing<T> {

    void compress(T t);

}
