package com.pearl.novdev.collection;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Map<String, String> studentMap = new HashMap<>();

        // Add entries
        studentMap.put("S001", "Alice");
        studentMap.put("S002", "Bob");
        studentMap.put("S003", "Charlie");

        // Update a value
        studentMap.put("S002", "Bobby"); // Bob -> Bobby

        // Print all entries
        System.out.println("All Students:");
        for (Map.Entry<String, String> entry : studentMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Access a value
        String name = studentMap.get("S001");
        System.out.println("\nStudent S001: " + name);

        // Check if a key or value exists
        System.out.println("Contains S003? " + studentMap.containsKey("S003"));
        System.out.println("Contains value 'Alice'? " + studentMap.containsValue("Alice"));

        // Remove an entry
        studentMap.remove("S003");

        // Display after removal
        System.out.println("\nAfter removing S003:");
        studentMap.forEach((id, studentName) -> System.out.println(id + ": " + studentName));
    }
}
