package com.dovile.javafuncional.functionalintarface;

import java.util.function.Function;

/**
 *
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public class _Function {

    public static void main(String[] args) {
        int increment = incrementByOne(0);
        System.out.println("By one " + increment);

        int increment2 = incrementByOneFuntion.apply(1);
        System.out.println("By onefuntion " + increment2);

        int multiply = multiplyBy10Funtion.apply(increment2);
        System.out.println(multiply);

        // Combine two functions it is the same like above the line there we get the multiply
        Function<Integer, Integer> addBy1AndThenMultiblyBy10
                = incrementByOneFuntion.andThen(multiplyBy10Funtion);
        System.out.println(addBy1AndThenMultiblyBy10.apply(4));
    }

    /**
     * @FunctionalInterface Function<T, R> t- type which is insert and r- type of result
     * More read {@link "https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/function/package-summary.html"}
     */
    static Function<Integer, Integer> incrementByOneFuntion =
            number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Funtion = number -> number * 10;

    /**
     * simple funtion which take one int variable and return int
     * @param number
     * @return number
     */
    static int incrementByOne(int number) {
        return number + 1;
    }
}
