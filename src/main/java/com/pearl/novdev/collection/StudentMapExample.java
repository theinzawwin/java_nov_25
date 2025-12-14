package com.pearl.novdev.collection;

import java.util.HashMap;
import java.util.Map;

public class StudentMapExample {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Map<String, MapStudent> studentMap = new HashMap<>();

        // Add students
        studentMap.put("S001", new MapStudent("Alice", 20, 85.0));
        studentMap.put("S002", new MapStudent("Bob", 22, 70.5));
        studentMap.put("S003", new MapStudent("Charlie", 21, 60.0));

        // Update student
        studentMap.put("S002", new MapStudent("Bobby", 22, 75.0)); // Bob updated

        // Retrieve by ID
        System.out.println("S001 Info: " + studentMap.get("S001"));

        // Check if ID exists
        System.out.println("Contains S004? " + studentMap.containsKey("S004"));

        // Remove student
        studentMap.remove("S003");

        // Print all students
        System.out.println("\nAll Students:");
        for (Map.Entry<String, MapStudent> entry : studentMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Filter and print students with grade >= 75
        System.out.println("\nStudents with Grade >= 75:");
        studentMap.values().stream()
                .filter(s -> s.grade >= 75)
                .forEach(System.out::println);
    }
}
