package com.dovile.javafuncional.optionals;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public class Main {

    public static void main(String[] args) {
        Object value = Optional.ofNullable("Hello")
                .orElseGet(() -> "default value");
        System.out.println(value);

        //Use Supplier interface
        Supplier<IllegalArgumentException> exception = () -> new IllegalArgumentException("exception");
        Object value1 = Optional.ofNullable("Hello")
                .orElseThrow(exception);
        System.out.println(value1);

        //Using ifPresent
        Optional.ofNullable("jonh@gmail.com")
                .ifPresent(email -> System.out.println("Sending email to: "+ email));

         Optional.ofNullable("jonh@gmail.com")
                .ifPresentOrElse(email -> System.out.println("Sending email to: "+ email),
                        ()->{
                            System.out.println("Can't send email");
                        });

        Optional.ofNullable(null)
                .ifPresentOrElse(email -> System.out.println("Sending email to: "+ email),
                        ()->{
                            System.out.println("Can't send email");
                        });
    }
}
