package com.pearl.novdev.stream.listexample;

import java.util.*;
import java.util.stream.Collectors;

public class ItemWithJavaStream {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item("Apple", 10, 2.5),
                new Item("Banana", 5, 1.2),
                new Item("Orange", 8, 1.8)
        );
        double totalRevenue = items.stream()
                .mapToDouble(i -> i.getQuantity() * i.getPrice())
                .sum();
        System.out.println("Total Revenue: $" + totalRevenue);

        // Filter Expensive Items (price > 2.0)
        List<Item> expensive = items.stream()
                .filter(i -> i.getPrice() > 2.0)
                .collect(Collectors.toList());
        expensive.forEach(i -> System.out.println(i.getName()));

        // Group by Item Name and Count Total Quantity
        Map<String, Integer> totalQuantities = items.stream()
                .collect(Collectors.toMap(
                        i -> i.getName(),
                        i -> i.getQuantity(),
                        Integer::sum // In case of duplicate names
                ));
        System.out.println(totalQuantities);

        // Highest Priced Item
        Optional<Item> maxPriceItem = items.stream()
                .max(Comparator.comparingDouble(i -> i.getPrice()));
        maxPriceItem.ifPresent(i -> System.out.println(i.getName() + " is the most expensive."));

    }
}
