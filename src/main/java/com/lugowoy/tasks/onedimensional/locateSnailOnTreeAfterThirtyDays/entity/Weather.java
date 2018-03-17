package com.lugowoy.tasks.onedimensional.locateSnailOnTreeAfterThirtyDays.entity;

import java.io.Serializable;
import java.util.Objects;

/** Created by Konstantin Lugowoy on 11.05.2017. */

public class Weather implements Serializable, Cloneable {

    private boolean cloudiness;

    public Weather() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weather)) return false;
        Weather weather = (Weather) o;
        return isCloudiness() == weather.isCloudiness();
    }

    @Override
    public int hashCode() {
        return Objects.hash(isCloudiness());
    }

    @Override
    public String toString() {
        return "Weather[" +
                "cloudiness=" + cloudiness +
                ']';
    }

    @Override
    public Weather clone() {
        Weather weather = new Weather();
        try {
            weather = (Weather) super.clone();
            weather.setCloudiness(this.isCloudiness());
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return weather;
    }

    public boolean isCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(boolean cloudiness) {
        this.cloudiness = cloudiness;
    }

}
