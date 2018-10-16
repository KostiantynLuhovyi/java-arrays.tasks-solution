package com.lugowoy.tasks.onedimensional.countingNumberOfPeopleWhoseAgeIsInGivenInterval;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

import java.util.Random;

/** Created by Konstantin Lugowoy on 14.05.2017. */

public class Main {

    private static final Random RANDOM_AGE = new Random();

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        ArrayOfHumans humans = getArrayOfHumans();

        int startAgeInterval = enterStartAgeInterval();

        int finishAgeInterval = enterFinishAgeInterval();

        Counting counting = Counting::countingTheNumberOfPeopleWithAgeInGivenInterval;
        counting.counting(humans, startAgeInterval, finishAgeInterval);

    }

    public static int enterFinishAgeInterval() {
        System.out.println("Enter finish age interval : ");
        int finishAgeInterval;
        while(true) {
            finishAgeInterval = READER.readInt();
            if ((finishAgeInterval > 0) && (finishAgeInterval <= 150)) {
                break;
            } else {
                System.err.println("Not correct value of finish age interval. Re-enter : ");
            }
        }
        return finishAgeInterval;
    }

    public static int enterStartAgeInterval() {
        System.out.println("Enter start age interval : ");
        int startAgeInterval;
        while(true) {
            startAgeInterval = READER.readInt();
            if ((startAgeInterval >= 0 ) && (startAgeInterval <= 140)) {
                break;
            } else {
                System.err.println("Not correct value of start age interval. Re-enter : ");
            }
        }
        return startAgeInterval;
    }

    public static ArrayOfHumans getArrayOfHumans() {
        ArrayOfHumans humans;
        System.out.println("Enter the number of people to count : ");
        while(true) {
            int numberOfPeople = READER.readInt();
            if (numberOfPeople > 0) {
                humans = createArrayOfHumans(numberOfPeople);
                break;
            } else {
                System.err.println("The number of people for counting is less than or equal to zero. Re-enter : ");
            }
        }
        return humans;
    }

    private static ArrayOfHumans createArrayOfHumans(int quantityHumans) {
        ArrayOfHumans arrayOfHumans = new ArrayOfHumans();
        arrayOfHumans.setHumans(new Human[quantityHumans]);
        for (int i = 0; i < arrayOfHumans.getHumans().length; i++) {
            arrayOfHumans.getHumans()[i] = new Human();
            arrayOfHumans.getHumans()[i].setAge(RANDOM_AGE.nextInt(130));
        }
        return arrayOfHumans;
    }

}
