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
    }

    /**
     * @FunctionalInterface Function<T, R> t- type which is insert and r- type of result
     * More read {@link "https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/function/package-summary.html"}
     */
    static Function<Integer, Integer> incrementByOneFuntion =
            number -> number + 1;

    static int incrementByOne(int number) {
        return number + 1;
    }
}
