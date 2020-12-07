package com.dovile.javafuncional.streams;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static com.dovile.javafuncional.streams._Stream.Gender.*;


/**
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public class _Stream {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Tom", MALE),
                new Person("Aish", FEMALE),
                new Person("Alice", FEMALE)
        );
        //Shows type of genders which have peoplw list without duplicate
        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        //Shows separate names length from people list:
        //The above line shows how it works using functions interface
        System.out.println("With functions interface");
        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = System.out::println;
        people.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(println);

        //The same result is using lambda
        System.out.println("With lambda");
        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        //AllMatch
        System.out.println("All match");
        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        boolean containsOnlyFemales = people.stream()
                .allMatch(personPredicate);
        System.out.println(containsOnlyFemales);

        //AnyMatch
        System.out.println("Any match");
        boolean containsOnlyFemalesAny = people.stream()
                .anyMatch(personPredicate);
        System.out.println(containsOnlyFemalesAny);

        //NoneMatch
        Predicate<Person> personPredicate1 = person -> UNISEX.equals(person.gender);
        System.out.println("None match");
        boolean containsOnlyFemalesNone = people.stream()
                .noneMatch(personPredicate1);
        System.out.println(containsOnlyFemalesNone);
    }

    @AllArgsConstructor
    @ToString
    static class Person {
        private final String name;
        private final Gender gender;
    }

    enum Gender {
        MALE,
        FEMALE,
        UNISEX
    }
}
