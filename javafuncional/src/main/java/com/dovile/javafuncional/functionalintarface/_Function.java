package com.dovile.javafuncional.functionalintarface;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public class _Function {

    public static void main(String[] args) {
        //Function takes 1 argument and produces 1 result
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

        //BiFunction takes 2 arguments and produces 1 result
        System.out.println(incrementByOneAndMultiply(4, 100));
        System.out.println(incrementByOneAndMultiplyFunction.apply(4, 100));
    }

    /**
     * @FunctionalInterface Function<T, R> t- type which is insert and r- type of result
     * More read {@link "https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/function/package-summary.html"}
     */
    static Function<Integer, Integer> incrementByOneFuntion =
            number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Funtion = number -> number * 10;

    /**
     * simple function which takes one int variable and returns int
     * @param number
     * @return int number + 1
     */
    static int incrementByOne(int number) {
        return number + 1;
    }

    /**
     * BiFunction<T, U, R> t- type of first insert variable, u- type of second variable, r-type of result
     * this function is the same like simple method below: incrementByOneAndMultiply
     */
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyFunction =
            (numberToIncrementByOne, numberToMultiplyBy) ->
                    (numberToIncrementByOne + 1) * numberToMultiplyBy;

    /**
     * simple function with two arguments which returns int
     * @param number
     * @param numToMultiplyBy
     * @return int (number + 1) * numToMultiplyBy
     */
    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }
}
