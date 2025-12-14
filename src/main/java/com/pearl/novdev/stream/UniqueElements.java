package com.pearl.novdev.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UniqueElements {

    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "banana", "apple", "orange");

        List<String> uniqueItems = items.stream()
                .distinct().map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(uniqueItems);

        long count = items.stream()
                .count();

        System.out.println("Total items: " + count);

        Optional<String> first = items.stream().findFirst();
        first.ifPresent(System.out::println); // apple
    }
}
