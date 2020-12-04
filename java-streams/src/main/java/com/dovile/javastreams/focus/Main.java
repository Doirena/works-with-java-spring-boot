package com.dovile.javastreams.focus;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();
        //Old method
        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (person.getGender().equals(Gender.FEMALE)) {
                females.add(person);
            }
        }

        females.forEach(System.out::println);

        //New one method
        System.out.println();
        System.out.println("***********Filter***********");
        //Filter
        List<Person> females1 = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
        females1.forEach(System.out::println);
        System.out.println();
        System.out.println("**********Sort************");

        //Sort by age and Gender
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender).reversed())
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);

        //All match
        System.out.println();
        System.out.println("**********All match************");
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 8);
        System.out.println(allMatch);

        //Any match
        System.out.println();
        System.out.println("**********Any match************");
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 8);
        System.out.println(anyMatch);

        //None match
        System.out.println();
        System.out.println("**********None match************");
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Antonio1"));
        System.out.println(noneMatch);

        //Max
        System.out.println();
        System.out.println("**********MAX************");
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent( System.out::println);

        //Min
        System.out.println();
        System.out.println("**********MIN************");
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent( System.out::println);

        //Group
        System.out.println();
        System.out.println("**********Group************");

        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        groupByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
        });

        //The oldest female
        System.out.println();
        System.out.println("**********The oldest female************");
        Optional<String> oldestFemaleAge = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);

        oldestFemaleAge.ifPresent(System.out::println);
    }

    public static List<Person> getPeople() {
        return List.of(
                new Person("Antonio", 20, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE)
        );
    }
}
