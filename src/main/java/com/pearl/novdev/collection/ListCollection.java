package com.pearl.novdev.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ListCollection {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple");
        System.out.println("Fruits: " + fruits);

        // Access Elements By Index
        System.out.println("Fruit at Index 1: " + fruits.get(1));

        // Update and Remove Elements
        fruits.set(1, "Mango");
        fruits.remove("Apple");
        System.out.println("Updated List: " + fruits);

        // Iterate over list
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Sort the List
        Collections.sort(fruits);
        System.out.println("Sorted: " + fruits);

        // Filter with A
      /*  List<String> startsWithA = fruits.stream()
                .filter(f -> f.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("Fruits starting with A: " + startsWithA);

        // Check List Properties
        System.out.println("Size: " + fruits.size());
        System.out.println("Contains Mango? " + fruits.contains("Mango"));
        System.out.println("Is empty? " + fruits.isEmpty());

       */
    }

}