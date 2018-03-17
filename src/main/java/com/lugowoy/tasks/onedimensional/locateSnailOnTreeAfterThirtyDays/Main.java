package com.lugowoy.tasks.onedimensional.locateSnailOnTreeAfterThirtyDays;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.tasks.onedimensional.locateSnailOnTreeAfterThirtyDays.entity.Snail;
import com.lugowoy.tasks.onedimensional.locateSnailOnTreeAfterThirtyDays.entity.Tree;
import com.lugowoy.tasks.onedimensional.locateSnailOnTreeAfterThirtyDays.entity.Weather;
import com.lugowoy.tasks.onedimensional.locateSnailOnTreeAfterThirtyDays.entity.WeatherArray;

import java.util.Arrays;
import java.util.Random;

/** Created by Konstantin Lugowoy on 11.05.2017. */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter the height of the tree : ");
        Tree tree = new Tree(READER.readInt());

        System.out.println("Enter the starting location of a snail on the tree : ");
        Snail snail = new Snail(READER.readInt());

        tree.setSnail(snail);

        System.out.println("Enter the number of days of observation : ");
        WeatherArray weatherArray = new WeatherArray(READER.readInt());

        weatherArray.setWeathers(Arrays.stream(new Weather[weatherArray.getNumberOfDaysOfWeatherObservation()])
                                       .map(weather -> weather = new Weather())
                                       .toArray(Weather[]::new));

        fillWeatherCloudinessInTheWeatherArray(weatherArray);

        Determinant<Tree, WeatherArray> determinant = Determinant::determineSnailLocationOnTree;
        determinant.determine(tree, weatherArray);

    }

    private static void fillWeatherCloudinessInTheWeatherArray(WeatherArray weatherArray) {
        Random random = new Random();

        Arrays.stream(weatherArray.getWeathers()).forEachOrdered(weather -> {
            int tmp = random.nextInt();
            if (tmp > 0) {
                weather.setCloudiness(true);
            }
        });

    }

}
