package com.dovile.javafuncional.imperative;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.dovile.javafuncional.imperative.Main.Gender.FEMALE;
import static com.dovile.javafuncional.imperative.Main.Gender.MALE;

/**
 *
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Tom", MALE),
                new Person("Aish", FEMALE),
                new Person("Alice", FEMALE)
        );

        //Imperative approach
        System.out.println("Imperative approach");
        List<Person> females = new ArrayList<>();
        for (Person person : people){
            if(FEMALE.equals(person.gender)){
                females.add(person);
            }
        }
        for (Person female: females) {
            System.out.println(female);
        }

        //Declarative approach
        System.out.println("Declarative approach");
        List<Person> females1 = people.stream()
                .filter(person -> person.gender.equals(FEMALE))
                .collect(Collectors.toList());

        females1.forEach(System.out::println);
    }

    @AllArgsConstructor
    @ToString
    static class Person{
        private final String name;
        private final Gender gender;
    }
    enum Gender{
        MALE,
        FEMALE
    }
}
