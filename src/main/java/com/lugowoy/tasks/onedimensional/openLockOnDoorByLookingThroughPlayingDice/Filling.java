package com.lugowoy.tasks.onedimensional.openLockOnDoorByLookingThroughPlayingDice;

/** Created by Konstantin Lugowoy on 27.03.2017. */

@FunctionalInterface
public interface Filling {

    void filling(DoorLock doorLock);

    static void fillingDoorLock(DoorLock doorLock) {
        for (int i = 0; i < doorLock.getPlayingDices().length; i++) {
            if (doorLock.getPlayingDices()[i] == null) {
                doorLock.getPlayingDices()[i] = new PlayingDice((int)(Math.random() * 6) + 1);
            } else if (doorLock.getPlayingDices()[i] != null) {
                doorLock.getPlayingDices()[i].setValue((int)((Math.random() * 6) + 1));
            }
        }
    }

}
