package com.lugowoy.tasks.onedimensional.countingTheNumberOfPeopleWhoseAgeIsInGivenInterval;

import java.util.Objects;

/** Created by Konstantin Lugowoy on 14.05.2017. */

public class ArrayOfHumans {

    private Human[] humans;

    public ArrayOfHumans() {
    }

    public ArrayOfHumans(Human[] humans) {
        if (Objects.nonNull(humans)) {
            this.humans = humans;
        }
    }

    public Human[] getHumans() {
        return humans;
    }

    public void setHumans(Human[] humans) {
        this.humans = humans;
    }

}
