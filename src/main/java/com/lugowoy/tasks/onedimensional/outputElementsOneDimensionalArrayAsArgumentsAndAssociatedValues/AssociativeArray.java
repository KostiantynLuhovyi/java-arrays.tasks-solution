package com.lugowoy.tasks.onedimensional.outputElementsOneDimensionalArrayAsArgumentsAndAssociatedValues;

/** Created by Konstantin Lugowoy on 23-Feb-17. */

public class AssociativeArray <T, V> {

    private T[] argumentArray;
    private V[] valueArray;

    private final Object[] associativeArray;

    public AssociativeArray(Object[] associativeArray) {
        this.associativeArray = associativeArray;
    }

    public Object[] getAssociativeArray() {
        return associativeArray;
    }

}
