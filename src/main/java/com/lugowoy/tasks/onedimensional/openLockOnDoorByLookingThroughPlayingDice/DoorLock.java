package com.lugowoy.tasks.onedimensional.openLockOnDoorByLookingThroughPlayingDice;

import java.util.Arrays;
import java.util.Random;

/** Created by Konstantin Lugowoy on 27.03.2017. */

public class DoorLock {

    public static final int VALUE_FOR_OPENING_THE_LOCK = 10;

    private PlayingDice[] playingDices = new PlayingDice[10];

    public DoorLock() {
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            playingDices[random.nextInt(10)] = new PlayingDice((int)(Math.random() * 6) + 1);
        }
    }

    @Override
    public String toString() {
        return "DoorLock[" +
                "playingDices=" + Arrays.toString(playingDices) +
                ']';
    }

    public PlayingDice[] getPlayingDices() {
        return playingDices;
    }

    public void setPlayingDices(PlayingDice[] playingDices) {
        this.playingDices = playingDices;
    }

}
