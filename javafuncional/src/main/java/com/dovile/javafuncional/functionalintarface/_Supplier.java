package com.dovile.javafuncional.functionalintarface;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public class _Supplier {

    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlSupplier.get());
        System.out.println(getDBConnectionUrlSupplierList.get());
    }

    /**
     * Simple java method
     *
     * @return string
     */
    static String getDBConnectionUrl() {
        return "jdbc://localhost:8080/user";
    }

    /**
     * Using Supplier<T> interface, t - type of argument which will be return.
     * This interface lets return any kind of variables.
     */
    static Supplier<String> getDBConnectionUrlSupplier = () -> "jdbc://localhost:8080/user";

    /**
     * For example Supplier interface method return list of String
     */
    static Supplier<List<String>> getDBConnectionUrlSupplierList = ()
            -> List.of("jdbc://localhost:8080/user", "jdbc://localhost:8080/customer");
}
