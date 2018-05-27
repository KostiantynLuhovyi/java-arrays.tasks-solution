package com.lugowoy.tasks.onedimensional.determineEquilibriumBetweenWeightOfSubjects;

import java.io.Serializable;
import java.util.Objects;

/** Created by Konstantin Lugowoy on 27.05.2018. */

public class Subject implements Serializable {

    private final int subId;
    private final int weight;

    public Subject(int subId, int weight) {
        this.subId = subId;
        this.weight = weight;
    }

    public Subject(Subject subject) {
        this.subId = subject.getSubId();
        this.weight = subject.getWeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject)) return false;
        Subject subject = (Subject) o;
        return getSubId() == subject.getSubId() &&
                getWeight() == subject.getWeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubId(), getWeight());
    }

    @Override
    public String toString() {
        return "Subject[" +
                "subId=" + subId +
                ", weight=" + weight +
                ']';
    }

    public int getSubId() {
        return subId;
    }

    public int getWeight() {
        return weight;
    }

}
