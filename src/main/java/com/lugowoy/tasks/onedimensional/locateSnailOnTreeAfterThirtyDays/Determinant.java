package com.lugowoy.tasks.onedimensional.locateSnailOnTreeAfterThirtyDays;

import com.lugowoy.tasks.onedimensional.locateSnailOnTreeAfterThirtyDays.entity.Snail;
import com.lugowoy.tasks.onedimensional.locateSnailOnTreeAfterThirtyDays.entity.Tree;
import com.lugowoy.tasks.onedimensional.locateSnailOnTreeAfterThirtyDays.entity.WeatherArray;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 11.05.2017. */

@FunctionalInterface
public interface Determinant<T, V> {

    void determine(T t, V v);

    static void determineSnailLocationOnTree(Tree tree, WeatherArray weatherArray) {
        Snail resultSnail = new Snail(tree.getSnail().getLocation());
        Arrays.stream(weatherArray.getWeathers()).forEachOrdered(weather -> {
            if (weather.isCloudiness()) {
                resultSnail.setLocation(tree.getSnail().getLocation() + 2);
            } else {
                resultSnail.setLocation(tree.getSnail().getLocation() - 1);
            }
        });
        if ((resultSnail.getLocation() < (tree.getHeight() * 100)) || (resultSnail.getLocation() > 0)) {
            tree.setSnail(resultSnail);
            System.out.println("Location snail on the tree : " + tree.getSnail().getLocation());
        } else {
            System.out.println("The snail descended from the tree or the snail rose higher than the height of the tree.");
        }
    }

}
