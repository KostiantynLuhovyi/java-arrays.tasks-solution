package com.lugowoy.tasks.onedimensional.locateSnailOnTreeAfterThirtyDays.entity;

import com.lugowoy.helper.other.DeepCloning;

import java.io.Serializable;
import java.util.Objects;

/** Created by Konstantin Lugowoy on 11.05.2017. */

public class Tree implements Serializable, Cloneable {

    private int height;

    private Snail snail;

    public Tree() {
    }

    public Tree(int height) {
        this.height = height;
    }

    public Tree(Snail snail) {
        this.snail = snail;
    }

    public Tree(int height, Snail snail) {
        this.height = height;
        this.snail = snail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tree)) return false;
        Tree tree = (Tree) o;
        return getHeight() == tree.getHeight() &&
                Objects.equals(getSnail(), tree.getSnail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeight(), getSnail());
    }

    @Override
    public String toString() {
        return "Tree[" +
                "height=" + height +
                ", snail=" + snail +
                ']';
    }

    @Override
    public Tree clone() {
        Tree tree = new Tree();
        try {
            tree = (Tree) super.clone();
            tree.setHeight(this.getHeight());
            tree.setSnail(DeepCloning.CLONER.deepClone(this.getSnail()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return tree;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Snail getSnail() {
        return snail;
    }

    public void setSnail(Snail snail) {
        this.snail = snail;
    }

}
