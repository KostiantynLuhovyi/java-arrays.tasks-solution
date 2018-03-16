package com.lugowoy.tasks.onedimensional.determineTimeOfStayOfCustomerInQueue;

import java.math.BigDecimal;

/** Created by Konstantin Lugowoy on 16.03.2017. */

public interface Determinant<T, V> {

    V determine(Queue<T> queue, int indexOfCustomer);

    static BigDecimal determineTimeOfStayCustomerInTheQueue(Queue<Customer> customerQueue, int indexOfCustomer) {
        BigDecimal resultTime = new BigDecimal(0);
        if (customerQueue != null) {
            if (customerQueue.getQueue() != null) {
                for (int i = 0; i < customerQueue.getQueue().length; i++) {
                    if (i != indexOfCustomer) {
                        resultTime = resultTime.add(Queue.getTimeService());
                    } else {
                        break;
                    }
                }
            }
        }
        return resultTime;
    }

}
