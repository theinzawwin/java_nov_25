package com.pearl.novdev.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNumberChecking {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6,8,9,10);

      /*  List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0).map(n->n+10)
                .collect(Collectors.toList());

        System.out.println(evens); // [2, 4, 6]
        */
        // Show Odd Number
		List<Integer> odds = numbers.stream().filter(n->n%2!=0).collect(Collectors.toList());
		System.out.println("=====Odd Number====");
		System.out.println(odds);

    }
}
