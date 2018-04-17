package com.lugowoy.tasks.onedimensional.determineTimeOfStayOfCustomerInQueue;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

/** Created by Konstantin Lugowoy on 16.03.2017. */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter number customer in the queue : ");
        int numberOfCustomersInTheQueue = READER.readInt();

        Queue<Customer> customerQueue = new Queue<>();

        fillCustomerQueue(customerQueue, numberOfCustomersInTheQueue);

        System.out.println("Result queue : ");
        Arrays.stream(customerQueue.getQueue()).forEachOrdered(System.out::println);
        System.out.println();

        System.out.println("Enter time of service for the customer : ");
        Queue.setTimeService(new BigDecimal(READER.readDouble()));

        Determinant<Customer, BigDecimal> determinant = Determinant::determineTimeOfStayCustomerInTheQueue;

        BigDecimal resultTime = determinant.determine(customerQueue, numberOfCustomersInTheQueue);

        System.out.printf("Result time : %f", resultTime.setScale(2, RoundingMode.DOWN).doubleValue());

    }

    private static void fillCustomerQueue(Queue<Customer> customerQueue, int quantityCustomers) {
        Customer[] customers = new Customer[quantityCustomers];
        for (int i = 0; i < quantityCustomers; i++) {
            customers[i] = new Customer();
        }
        customerQueue.setQueue(customers);
    }

}
