package com.dovile.javafuncional.functionalintarface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public class _Predicate {

    public static void main(String[] args) {

        String pho_1 = "07000000000";
        String pho_2 = "0700000000";
        String pho_3 = "09009877300";
        String pho_4 = "07000000003";

        System.out.println("Without predicate:");
        System.out.println(isPhoneNumberValid(pho_1));
        System.out.println(isPhoneNumberValid(pho_2));
        System.out.println(isPhoneNumberValid(pho_3));

        System.out.println("With predicate:");
        System.out.println(isPhoneNumberValidPredicate.test(pho_1));
        System.out.println(isPhoneNumberValidPredicate.test(pho_2));
        System.out.println(isPhoneNumberValidPredicate.test(pho_3));

        System.out.println("Predicate and: "+isPhoneNumberValidPredicate.and(containsNumber3).test(pho_3));
        System.out.println("Predicate or: "+isPhoneNumberValidPredicate.or(containsNumber3).test(pho_1));
        System.out.println("Predicate and: "+isPhoneNumberValidPredicate.and(containsNumber3).test(pho_4));

        System.out.println("Bi predicate and: "+isPhoneNumberValidBiPredicate_AND.test(pho_1,pho_4));
        System.out.println("Bi predicate or: "+isPhoneNumberValidBiPredicate_OR.test(pho_3,pho_4));

    }

    /**
     * Simple java function
     * @param phoneNumber
     * @return boolean
     */
    static boolean isPhoneNumberValid (String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    /**
     * Predicate interface <T> t - type of argument
     */
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");
    /**
     * BiPredicate<T, U> interface t - type of firts arguments, u - type of second argument
     */
    static BiPredicate<String, String> isPhoneNumberValidBiPredicate_AND = (phoneNumber_1, phoneNumber_2) ->
            phoneNumber_1.startsWith("07") && phoneNumber_1.length() == 11 && phoneNumber_2.contains("3");

    static BiPredicate<String, String> isPhoneNumberValidBiPredicate_OR = (phoneNumber_1, phoneNumber_2) ->
            phoneNumber_1.startsWith("07") && phoneNumber_1.length() == 11 || phoneNumber_2.contains("3");




}
