package com.pearl.novdev.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertStringToUpperAndCheckMatchCondition {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<String> words = Arrays.asList("java", "stream", "api");

        List<String> upper = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());



        System.out.println(upper); // [JAVA, STREAM, API]
        // Check Match Condtion

        boolean hasLongWord = words.stream()
                .anyMatch(word -> word.length() > 4);
        System.out.println("After Checking Match=>");
        System.out.println(hasLongWord); // true

    }
}
