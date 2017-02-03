package com.company;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumSquaredDivisors {
    public static String listSquared(long m, long n) {

        return "[" + IntStream.range((int) m, (int) n).boxed().collect(Collectors.toList()).stream()
                .map(y -> new Result(y.intValue(), computSumOfSquaredDivisors(y)))
                .filter(x -> {
                    int srt = (int) Math.sqrt(x.sumOfSquaredDivisors);
                    return x.sumOfSquaredDivisors == srt * srt;
                })
                .map(y -> "[" + y.number + ", " + y.sumOfSquaredDivisors + "]")
                .reduce((first, second) -> first + ", " + second).orElse("")
                + "]";

    }

    public static int computSumOfSquaredDivisors(int number) {
        return IntStream.rangeClosed(1, number).filter(x -> number % x == 0).map(y -> y * y).reduce((x, y) -> x + y).getAsInt();
    }

    public static void main(String[] args) {
        System.out.println((listSquared(1, 250)));
    }
}

class Result {
    int number;
    int sumOfSquaredDivisors;

    public Result(int a, int b) {
        number = a;
        sumOfSquaredDivisors = b;
    }
}