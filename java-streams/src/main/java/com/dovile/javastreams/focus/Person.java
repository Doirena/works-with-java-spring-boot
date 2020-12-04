package com.dovile.javastreams.focus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Person {
    private final String name;
    private final int age;
    private final Gender gender;
}
