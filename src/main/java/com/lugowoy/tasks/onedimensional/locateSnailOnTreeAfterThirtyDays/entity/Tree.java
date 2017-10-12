package com.lugowoy.tasks.onedimensional.locateSnailOnTreeAfterThirtyDays.entity;

/** Created by Konstantin Lugowoy on 11.05.2017. */

public class Tree {

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
