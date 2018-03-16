package com.lugowoy.tasks.onedimensional.determineTimeOfStayOfCustomerInQueue;

import com.lugowoy.helper.other.DeepCloning;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/** Created by Konstantin Lugowoy on 16.03.2017. */
public class Customer implements Serializable, Cloneable {

    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();

    private int idCustomer;
    private String nameCustomer;

    public Customer() {
        this.idCustomer = ATOMIC_INTEGER.incrementAndGet();
        this.nameCustomer = "name:" + this.idCustomer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getIdCustomer() == customer.getIdCustomer() &&
                Objects.equals(getNameCustomer(), customer.getNameCustomer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCustomer(), getNameCustomer());
    }

    @Override
    public String toString() {
        return "Customer[" +
                "idCustomer=" + idCustomer +
                ", nameCustomer='" + nameCustomer + '\'' +
                ']';
    }


    @Override
    public Customer clone() {
        Customer customer = new Customer();
        try {
            customer = (Customer) super.clone();
            customer.idCustomer = this.getIdCustomer();
            customer.nameCustomer = DeepCloning.CLONER.deepClone(this.getNameCustomer());
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return customer;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

}
