package com.pearl.novdev.collection;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
		/*Set<String> fruits = new HashSet<>();
		// Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple");
        System.out.println("Fruits: " + fruits);

        // Iterate over Set
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Check Existence and Remove Elements
        System.out.println(fruits.contains("Banana"));

        fruits.remove("Orange");
        System.out.println(fruits);
        */
        // Remove Duplicate From List
       List<String> names = Arrays.asList("Anna", "Bob", "Anna", "Eve");

        Set<String> uniqueNames = new HashSet<>(names);
        System.out.println("Unique names: " + uniqueNames);

        //showTreeSet();
    }

    public static void showTreeSet() {
        Set<Integer> numbers = new TreeSet<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(2); // Duplicate

        System.out.println("Sorted numbers: " + numbers);
    }
}
