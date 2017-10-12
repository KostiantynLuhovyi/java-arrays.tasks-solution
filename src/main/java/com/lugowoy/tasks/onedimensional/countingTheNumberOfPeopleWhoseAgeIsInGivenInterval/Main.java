package com.lugowoy.tasks.onedimensional.countingTheNumberOfPeopleWhoseAgeIsInGivenInterval;

import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingDataUserInputInConsole;

import java.util.Random;

/** Created by Konstantin Lugowoy on 14.05.2017. */

public class Main {

    private static final Random RANDOM_AGE = new Random();

    private static Reader reader = new Reader(new ReadingDataUserInputInConsole());

    public static void main(String[] args) {

        ArrayOfHumans humans = getArrayOfHumans();

        int startAgeInterval = getStartAgeInterval();

        int finishAgeInterval = getFinishAgeInterval();

        Counting counting = Counting::countingTheNumberOfPeopleWithAgeInGivenInterval;
        counting.counting(humans, startAgeInterval, finishAgeInterval);

    }

    public static int getFinishAgeInterval() {
        System.out.println("Enter finish age interval : ");
        int finishAgeInterval;
        while(true) {
            finishAgeInterval = reader.readInt();
            if ((finishAgeInterval > 0) && (finishAgeInterval <= 150)) {
                break;
            } else {
                System.out.println("Not correct value of finish age interval. Re-enter : ");
            }
        }
        return finishAgeInterval;
    }

    public static int getStartAgeInterval() {
        System.out.println("Enter start age interval : ");
        int startAgeInterval;
        while(true) {
            startAgeInterval = reader.readInt();
            if ((startAgeInterval >= 0 ) && (startAgeInterval <= 140)) {
                break;
            } else {
                System.out.println("Not correct value of start age interval. Re-enter : ");
            }
        }
        return startAgeInterval;
    }

    public static ArrayOfHumans getArrayOfHumans() {
        ArrayOfHumans humans;
        System.out.println("Enter the number of people to count : ");
        while(true) {
            int numberOfPeople = reader.readInt();
            if (numberOfPeople > 0) {
                humans = createArrayOfHumans(numberOfPeople);
                break;
            } else {
                System.out.println("The number of people for counting is less than or equal to zero. Re-enter : ");
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
