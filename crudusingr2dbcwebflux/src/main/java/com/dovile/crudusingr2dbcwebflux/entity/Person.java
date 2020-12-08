package com.dovile.crudusingr2dbcwebflux.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

/**
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
@Getter
@Setter
@ToString
public class Person {

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
