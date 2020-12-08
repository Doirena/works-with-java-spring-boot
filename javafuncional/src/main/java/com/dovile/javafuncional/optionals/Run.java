package com.dovile.javafuncional.optionals;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

/**
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public class Run {

    public static void main(String[] args) {

        Optional<String> hello = Optional.ofNullable("hello");
        System.out.println(hello.isPresent());
        System.out.println(hello.isEmpty());

        String orElse = hello
                .map(String::toUpperCase)
                .orElseGet(() -> {
                    // ... extra logic what u want to do
                    return "world"; // this u get when hello = Optional.ofNullable(null);
                });
//                .orElse("world");
        System.out.println(orElse);


        Optional<String> hello1 = Optional.ofNullable("hello1");

        hello1.ifPresent(word -> {
            System.out.println(word);
        });

        hello1.ifPresentOrElse(System.out::println, () -> System.out.println("world1"));

        //Everything will be ok
        Person person = new Person("Tom", "TOM@gmail.com");
        System.out.println(person.getEmail().map(s -> s.toLowerCase()).orElse("email is not provide"));
        //print orElse email is not provide
        Person person1 = new Person("Tom", null);
        System.out.println(person1.getEmail().map(s -> s.toLowerCase()).orElse("email is not provide"));

        //Analogue
        Person person2 = new Person("Tom", null);
        if (person2.getEmail().isPresent()){
            String email = person2.getEmail().get();
            System.out.println(email.toLowerCase());
        }else{
            System.out.println("email is not provide");
        }


    }
}

@AllArgsConstructor
class Person {
    @Getter
    private final String name;
    private final String email;

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
}

