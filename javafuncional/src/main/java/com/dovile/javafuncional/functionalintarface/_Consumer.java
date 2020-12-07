package com.dovile.javafuncional.functionalintarface;

import lombok.AllArgsConstructor;

import java.util.function.Consumer;

/**
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public class _Consumer {

    public static void main(String[] args) {
        Customer maria = new Customer("Maria", "999999");
        //Normal java function
        greetCustomer(maria);

        //Function interface Consumer
        greetCustomerConsumer.accept(maria);
    }

    /**
     * Function made using Function Consumer<T>, t-type of insert argument, interface
     */
    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello  "+ customer.customerName
                    +", thanks for registering phone number "
                    +customer.customerPhoneNumber);

    /**
     * Simple java function
     * @param customer
     */
    static void greetCustomer(Customer customer){
        System.out.println("Hello  "+ customer.customerName
                +", thanks for registering phone number "
                +customer.customerPhoneNumber);
    }

    @AllArgsConstructor
    static class Customer{
        private final String customerName;
        private final String customerPhoneNumber;
    }


}
