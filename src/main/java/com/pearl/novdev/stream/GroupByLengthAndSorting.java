package com.pearl.novdev.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByLengthAndSorting {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<String> names = Arrays.asList("Tom", "Anna", "Bob", "Elizabeth");

        Map<Integer, List<String>> grouped = names.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(grouped);
        // {3=[Tom, Bob], 4=[Anna], 9=[Elizabeth]}


        List<String> namesForSorting = Arrays.asList("Zara", "Alice", "Bob");
        System.out.println("After sorting===>");
        List<String> sorted = namesForSorting.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sorted); // [Alice, Bob, Zara]
    }
}
