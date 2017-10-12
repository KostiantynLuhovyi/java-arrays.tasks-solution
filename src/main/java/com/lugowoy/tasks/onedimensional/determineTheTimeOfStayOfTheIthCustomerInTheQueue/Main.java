package com.lugowoy.tasks.onedimensional.determineTheTimeOfStayOfTheIthCustomerInTheQueue;

import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingDataUserInputInConsole;

import java.math.BigDecimal;
import java.util.Arrays;

/** Created by Konstantin Lugowoy on 16.03.2017. */

public class Main {

    private static Reader reader = new Reader(new ReadingDataUserInputInConsole());

    public static void main(String[] args) {

        System.out.println("Enter number customer in the queue : ");
        int numberOfCustomersInTheQueue = reader.readInt();

        Queue<Customer> customerQueue = new Queue<>();

        fillCustomerQueue(customerQueue, numberOfCustomersInTheQueue);

        System.out.println("Result queue : ");
        Arrays.stream(customerQueue.getQueue()).forEachOrdered(System.out::println);
        System.out.println();

        System.out.println("Enter time of service for the customer : ");
        Queue.setTimeService(new BigDecimal(reader.readDouble()));

        Determinable<Customer, BigDecimal> determinable = Determinable::determineTimeOfStayCustomerInTheQueue;

        BigDecimal resultTime = determinable.determine(customerQueue, numberOfCustomersInTheQueue);

        System.out.printf("Result time : %f", resultTime.setScale(2, BigDecimal.ROUND_DOWN).doubleValue());

    }

    private static void fillCustomerQueue(Queue<Customer> customerQueue, int quantityCustomers) {
        Customer[] customers = new Customer[quantityCustomers];
        for (int i = 0; i < quantityCustomers; i++) {
            customers[i] = new Customer();
        }
        customerQueue.setQueue(customers);
    }

}
