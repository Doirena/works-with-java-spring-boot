package com.dovile.javafuncional.finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public class Lambdas {

    public static void main(String[] args) {

        Function<String, String> upperCaseName_1 = name -> name.toUpperCase();
        Function<String, String> upperCaseName_2 = name -> {
            //logic
            if(name.isBlank()) throw new IllegalArgumentException("");
            return name.toUpperCase();
        };

        BiFunction<String, Integer, String> upperCaseName_3 = (name, age) -> {
            //logic
            if(name.isBlank()) throw new IllegalArgumentException("");
            System.out.println(age);
            return name.toUpperCase();
        };

        System.out.println(upperCaseName_1.apply("Ben"));
        System.out.println(upperCaseName_2.apply("Alex"));
        System.out.println(upperCaseName_3.apply("Tom", 50));
    }
}
