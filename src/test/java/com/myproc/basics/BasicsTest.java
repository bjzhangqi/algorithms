package com.myproc.basics;

import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicsTest {
    @Test
    public void testStream() {
        List<String> lstr = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        System.out.println(lstr);
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double::min).ifPresent(System.out::println);
    }

    @Test
    public void testStreamGenerate() {
        Random seed = new Random();
        Supplier<Integer> random = seed::nextInt;
        System.out.println(random.getClass().getName());
        Stream.generate(random).limit(10).forEach(System.out::println);
//Another way
        IntStream.generate(() -> (int) (System.nanoTime() % 100)).
                limit(10).forEach(System.out::println);
    }
}
