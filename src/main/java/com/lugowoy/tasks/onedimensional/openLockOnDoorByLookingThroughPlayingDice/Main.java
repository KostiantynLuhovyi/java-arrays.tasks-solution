package com.lugowoy.tasks.onedimensional.openLockOnDoorByLookingThroughPlayingDice;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/** Created by Konstantin Lugowoy on 27.03.2017. */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    private static final Filling FILLING = Filling::fillingDoorLock;

    private static final Opening OPENING = Opening::openDoorLock;

    public static void main(String[] args) {
        DoorLock doorLock = new DoorLock();
        System.out.println(doorLock);

        String resume;
        do {
            FILLING.filling(doorLock);
            System.out.println(doorLock);
            if (OPENING.open(doorLock)) {
                System.out.println("Door open.");
                break;
            } else {
                System.out.println("Door not open. Do you want to repeat, press \'r\'.");
                System.out.println("If you do not want to repeat, press \'f\'.");
                System.out.println("Enter : ");
                resume = READER.readString();

                if (resume.equals("f")) break;
            }

        } while (resume.equals("r"));

    }

}
