package com.lugowoy.tasks.onedimensional.countingNumberOfPeopleWhoseAgeIsInGivenInterval;

/**
 * Created by Konstantin Lugowoy on 14.05.2017.
 */

@FunctionalInterface
public interface Counting {

    void counting(ArrayOfHumans humans, int startAgeInterval, int finishAgeInterval);

    static void countingTheNumberOfPeopleWithAgeInGivenInterval(ArrayOfHumans humans, int startAgeInterval, int finishAgeInterval) {
        int resultCount = 0;
        if (humans != null) {
            if ((startAgeInterval >= 0) && (finishAgeInterval <= 130)) {
                if (startAgeInterval < finishAgeInterval) {
                    for (Human human : humans.getHumans()) {
                        if ((human.getAge() >= startAgeInterval) && (human.getAge() <= finishAgeInterval)) {
                            resultCount++;
                        }
                    }
                    System.out.printf("The number of people whose age is in the range from %d to %d is equal to %d .",
                                                                      startAgeInterval, finishAgeInterval, resultCount);
                } else {
                    System.err.println("Incorrect data. Can not count.");
                }
            } else {
                System.err.println("Incorrect data. Can not count.");
            }
        } else {
            System.err.println("The array is not valid for any operations or calculations.");
        }
    }

}
