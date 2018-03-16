package com.lugowoy.tasks.onedimensional.determineTimeOfStayOfCustomerInQueue;

import java.math.BigDecimal;

/** Created by Konstantin Lugowoy on 16.03.2017. */

public class Queue<T> {

    private static BigDecimal timeService;

    private T[] queue;

    public Queue() {
    }

    public Queue(T[] queue) {
        this.queue = queue;
    }

    public T[] getQueue() {
        return queue;
    }

    public void setQueue(T[] queue) {
        this.queue = queue;
    }

    public static BigDecimal getTimeService() {
        return timeService;
    }

    public static void setTimeService(BigDecimal timeService) {
        Queue.timeService = timeService;
    }

}
