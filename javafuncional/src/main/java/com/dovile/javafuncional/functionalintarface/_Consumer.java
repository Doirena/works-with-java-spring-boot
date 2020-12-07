package com.dovile.javafuncional.functionalintarface;

import lombok.AllArgsConstructor;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public class _Consumer {

    public static void main(String[] args) {
        Customer maria = new Customer("Maria", "999999");
        //Normal java function
        greetCustomer(maria);
        greetCustomerV2(maria, false);

        //Function interface Consumer
        greetCustomerConsumer.accept(maria);
        greetCustomerConsumerV2.accept(maria, false);
    }

    /**
     * Function made using Function Consumer<T>, t-type of insert argument, interface
     */
    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello  " + customer.customerName
                    + ", thanks for registering phone number "
                    + customer.customerPhoneNumber);

    /**
     * interface BiConsumer<T, U> has to parameters, t - type of first arguments
     * u - second argument, in example we take boolean if true shows number otherwise hide numeber
     * analogue function is greetCustomerV2
     */
    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.println("Hello  " + customer.customerName
                    + ", thanks for registering phone number "
                    + (showPhoneNumber ? customer.customerPhoneNumber : "hide number"));

    /**
     * Simple java function
     *
     * @param customer
     */
    static void greetCustomer(Customer customer) {
        System.out.println("Hello  " + customer.customerName
                + ", thanks for registering phone number "
                + customer.customerPhoneNumber);
    }

    /**
     * Simple java function with two arguments
     *
     * @param customer
     * @param showPhoneNumber
     */
    static void greetCustomerV2(Customer customer, boolean showPhoneNumber) {
        System.out.println("Hello  " + customer.customerName
                + ", thanks for registering phone number "
                + (showPhoneNumber ? customer.customerPhoneNumber : "hide number"));
    }

    @AllArgsConstructor
    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;
    }

}
