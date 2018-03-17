package com.lugowoy.tasks.onedimensional.openLockOnDoorByLookingThroughPlayingDice;

/** Created by Konstantin Lugowoy on 27.03.2017. */

public class PlayingDice {

    private int value;

    public PlayingDice() {
    }

    public PlayingDice(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PlayingDice[" +
                "value=" + value +
                ']';
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
