package com.dovile.javafuncional.combinatorpattern;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

/**
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
@AllArgsConstructor
@Getter
public class Customer {

    private final String name;
    private final String email;
    private final String phoneNumber;
    private final LocalDate dob;
}
