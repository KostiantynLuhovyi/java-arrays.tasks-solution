package com.lugowoy.tasks.onedimensional.locateSnailOnTreeAfterThirtyDays.entity;

import java.io.Serializable;
import java.util.Objects;

/** Created by Konstantin Lugowoy on 11.05.2017. */

public class Snail implements Serializable, Cloneable {

    private int location;

    public Snail() {
    }

    public Snail(int location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Snail)) return false;
        Snail snail = (Snail) o;
        return getLocation() == snail.getLocation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocation());
    }

    @Override
    public String toString() {
        return "Snail[" +
                "location=" + location +
                ']';
    }

    @Override
    public Snail clone() {
        Snail snail = new Snail();
        try {
            snail = (Snail) super.clone();
            snail.setLocation(this.getLocation());
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return snail;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

}
