package com.lugowoy.tasks.onedimensional.interchangedMaximumAndMinimumElementOfArray;

import java.util.Arrays;
import java.util.Random;

/**Created by Konstantin Lugowoy on 14-Feb-17.*/

public class Main {

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 100;

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        Numbers numbers = new Numbers(MAX_RANDOM_NUMBER,
                                      MIN_RANDOM_NUMBER,
                                      Arrays.stream(new Integer[20]).mapToInt(value -> RANDOM.nextInt(100)).toArray());

        System.out.println("Original array : ");
        Arrays.stream(numbers.getNumbers()).forEachOrdered(value -> System.out.print(value + " "));
        System.out.println();

        INTERCHANGING.interchange(numbers);

        System.out.println("Max element : " + numbers.getMaxElement());
        System.out.println("Min element : " + numbers.getMinElement());

        System.out.println("An array after exchange of places of the maximum and minimum element : ");
        Arrays.stream(numbers.getNumbers()).forEachOrdered(value -> System.out.print(value + " "));

    }

    private static final Interchanging INTERCHANGING = numbers -> {
        int indexMaxElement = 0, indexMinElement = 0;

        GetMaxAndMinElement getMaxAndMinElement = new GetMaxAndMinElement(numbers, indexMaxElement, indexMinElement).invoke();
        indexMaxElement = getMaxAndMinElement.getIndexMaxElement();
        indexMinElement = getMaxAndMinElement.getIndexMinElement();

        exchangeMinAndMaxElementInTheArray(numbers, indexMaxElement, indexMinElement);
    };

    private static void exchangeMinAndMaxElementInTheArray(Numbers numbers, int indexMaxElement, int indexMinElement) {
        for (int index = 0; index < numbers.getNumbers().length; index++) {
            if (index == indexMaxElement) {
                numbers.getNumbers()[index] = numbers.getMinElement();
            } else if (index == indexMinElement) {
                numbers.getNumbers()[index] = numbers.getMaxElement();
            }
        }
    }

    private static class GetMaxAndMinElement {
        private final Numbers numbers;
        private int indexMaxElement;
        private int indexMinElement;

        GetMaxAndMinElement(Numbers numbers, int indexMaxElement, int indexMinElement) {
            this.numbers = numbers;
            this.indexMaxElement = indexMaxElement;
            this.indexMinElement = indexMinElement;
        }

        int getIndexMaxElement() {
            return indexMaxElement;
        }

        int getIndexMinElement() {
            return indexMinElement;
        }

        GetMaxAndMinElement invoke() {
            int value;
            for (int index = 0; index < numbers.getNumbers().length; index++) {
                value = numbers.getNumbers()[index];

                if (value > numbers.getMaxElement()) {
                    numbers.setMaxElement(value);
                    indexMaxElement = index;
                }
                if (value < numbers.getMinElement() || value == 0) {
                    numbers.setMinElement(value);
                    indexMinElement = index;
                }
            }
            return this;
        }

    }

}
