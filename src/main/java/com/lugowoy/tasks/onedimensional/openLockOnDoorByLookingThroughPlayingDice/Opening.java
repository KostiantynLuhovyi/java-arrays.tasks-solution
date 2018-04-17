package com.lugowoy.tasks.onedimensional.openLockOnDoorByLookingThroughPlayingDice;

/** Created by Konstantin Lugowoy on 27.03.2017. */

@FunctionalInterface
public interface Opening {

    boolean open(DoorLock doorLock);

    static boolean openDoorLock(DoorLock doorLock) {
        boolean openingResult = false;
        for (int i = 0; i < doorLock.getPlayingDices().length - 2; i++) {
            if ((doorLock.getPlayingDices()[i].getValue()
                    + doorLock.getPlayingDices()[i + 1].getValue()
                        + doorLock.getPlayingDices()[i + 2].getValue()) == DoorLock.VALUE_FOR_OPENING_THE_LOCK) {
                openingResult = true;
            }
        }
        return openingResult;
    }

}
