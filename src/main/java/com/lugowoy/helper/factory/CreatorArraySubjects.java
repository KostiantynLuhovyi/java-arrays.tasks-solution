package com.lugowoy.helper.factory;

import com.lugowoy.helper.factory.creator.CreatingArray;
import com.lugowoy.helper.factory.creator.CreatorArray;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.tasks.onedimensional.determineEquilibriumBetweenWeightOfSubjects.Subject;

/**
 * Created by Konstantin Lugowoy on 27.05.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * The class implements a contract that creates objects of the {@link Array} type encapsulating an array of object of the {@link Subject} class.
 * This class is needed to solve some tasks with the comparison of the weight of {@link Subject}.
 *
 * @see com.lugowoy.helper.factory.creator.Creator
 * @see com.lugowoy.helper.factory.creator.CreatorArray
 * @see com.lugowoy.helper.factory.creator.Creating
 * @see com.lugowoy.helper.factory.creator.CreatingArray
 * */

public class CreatorArraySubjects extends CreatorArray<Subject> implements CreatingArray<Subject> {

    /**
     * The method creates an object of the {@link Array} type that calls the default constructor.
     *
     * @see com.lugowoy.helper.factory.creator.Creator
     * @see com.lugowoy.helper.factory.creator.CreatorArray
     * @see com.lugowoy.helper.factory.creator.Creating
     * @see com.lugowoy.helper.models.arrays.Array
     *
     * @return The created object of type {@link Array}.
     * */
    @Override
    public Array<Subject> create() {
        return new Array<>();
    }

    /**
     * The method creates an object of the {@link Array} type that calls the constructor with parameter {@link Array#Array(Object[])}.
     *
     * @see com.lugowoy.helper.factory.creator.CreatorArray
     * @see com.lugowoy.helper.factory.creator.CreatingArray
     *
     * @see com.lugowoy.helper.models.arrays.Array
     *
     * @param subjects An array of objects of the {@link Subject} class that will be encapsulate in the created class object {@link Array}.
     *
     * @return The created object of type {@link Array}.
     * */
    @Override
    public Array<Subject> create(Subject[] subjects) {
        return new Array<>(subjects);
    }

    /**
     * The method creates an object of the {@link Array} type that calls the constructor with parameter {@link Array#Array(int)}.
     *
     * @see com.lugowoy.helper.factory.creator.CreatorArray
     * @see com.lugowoy.helper.factory.creator.CreatingArray
     *
     * @see com.lugowoy.helper.models.arrays.Array
     *
     * @param lengthArray Length of array of objects that will be encapsulate in the created class object {@link Array}.
     *
     * @return The created object {@link Array} encapsulates an array of the length of the passed parameter.
     * */
    @Override
    public Array<Subject> create(int lengthArray) {
        return new Array<>(lengthArray);
    }

}
