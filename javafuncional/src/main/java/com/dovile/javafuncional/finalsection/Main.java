package com.dovile.javafuncional.finalsection;

import java.util.function.Consumer;

/**
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public class Main {

    public static void main(String[] args) {

        hello("John", null, value -> {
            System.out.println("no lastName provide for " + value);
        });

        hello2("John", null, () -> {
            System.out.println("no lastName provide for ");
        });

    }

    static void hello(String firtsName, String lastName, Consumer<String> callback) {
        System.out.println(firtsName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firtsName);
        }
    }

    static void hello2(String firtsName, String lastName, Runnable callback) {
        System.out.println(firtsName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }

    }
    // Js looks like:
    //    function hello (firstName, lastName, callback){
    //        console.log(firstName);
    //        if(lastName){
    //            console.log(lastName);
    //        } else {
    //            callback();
    //        }
    //    }
}
