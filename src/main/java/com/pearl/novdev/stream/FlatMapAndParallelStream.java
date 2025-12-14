package com.pearl.novdev.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapAndParallelStream {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<List<String>> nested = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"));

        List<String> flat = nested.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(flat); // [a, b, c, d]

        // Parallel Stream
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);

        int sum = nums.parallelStream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum: " + sum); // 21

        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
        listOfNumbers.parallelStream().forEach(number ->
                System.out.println(number + " " + Thread.currentThread().getName())
        );

        /*
        listOfNumbers.stream().forEach(number ->
                System.out.println(number + " " + Thread.currentThread().getName())
        );

         */
    }
}
