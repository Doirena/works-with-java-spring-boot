package com.dovile.javafuncional.combinatorpattern;

import java.time.LocalDate;

import static com.dovile.javafuncional.combinatorpattern.CutomerRegistrationValidator.*;

/**
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+370655555555",
                LocalDate.of(2000, 1, 1));

        //Simple Java valid
        System.out.println(new CustomerValidatorService().isValid(customer));

        //If valid we can store customer in db:
        //Using combinator pattern:
        System.out.println("Using Combinator pattern:");
        ValidationResult result = isEmailValid()
                .and(isPhoneValid())
                .and(isAdult())
                .apply(customer);

        System.out.println(result);

        if(result != ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }
    }
}
