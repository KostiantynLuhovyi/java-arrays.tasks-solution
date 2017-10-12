package com.lugowoy.tasks.onedimensional.locateSnailOnTreeAfterThirtyDays.entity;

/** Created by Konstantin Lugowoy on 11.05.2017. */

public class WeatherArray {

    private int numberOfDaysOfWeatherObservation;

    private Weather[] weathers;

    public WeatherArray() {
    }

    public WeatherArray(int numberOfDaysOfWeatherObservation) {
        this.numberOfDaysOfWeatherObservation = numberOfDaysOfWeatherObservation;
    }

    public WeatherArray(Weather[] weathers) {
        this.weathers = weathers;
    }

    public WeatherArray(int numberOfDaysOfWeatherObservation, Weather[] weathers) {
        this.numberOfDaysOfWeatherObservation = numberOfDaysOfWeatherObservation;
        this.weathers = weathers;
    }

    public int getNumberOfDaysOfWeatherObservation() {
        return numberOfDaysOfWeatherObservation;
    }

    public void setNumberOfDaysOfWeatherObservation(int numberOfDaysOfWeatherObservation) {
        this.numberOfDaysOfWeatherObservation = numberOfDaysOfWeatherObservation;
    }

    public Weather[] getWeathers() {
        return weathers;
    }

    public void setWeathers(Weather[] weathers) {
        this.weathers = weathers;
    }

}
