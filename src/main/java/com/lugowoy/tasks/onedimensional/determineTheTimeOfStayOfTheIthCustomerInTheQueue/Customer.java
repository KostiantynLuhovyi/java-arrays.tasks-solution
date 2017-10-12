package com.lugowoy.tasks.onedimensional.determineTheTimeOfStayOfTheIthCustomerInTheQueue;

/** Created by Konstantin Lugowoy on 16.03.2017. */
public class Customer {

    private static int utilIdentificator;

    private int idCustomer;
    private String nameCustomer;

    public Customer() {
        utilIdentificator++;
        this.idCustomer = utilIdentificator;
        this.nameCustomer = "name:" + utilIdentificator;
    }

    @Override
    public String toString() {
        return "Customer[" +
                "idCustomer=" + idCustomer +
                ", nameCustomer='" + nameCustomer + '\'' +
                ']';
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

}
