package com.pearl.novdev.collection;

import java.util.HashSet;
import java.util.Set;

public class StudentSetExample {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Set<SetStudent> studentSet = new HashSet<>();

        studentSet.add(new SetStudent("S001", "Alice"));
        studentSet.add(new SetStudent("S002", "Bob"));
        studentSet.add(new SetStudent("S003", "Charlie"));
        studentSet.add(new SetStudent("S001", "Alice")); // Duplicate ID

        System.out.println("All Students in Set:");
        for (SetStudent s : studentSet) {
            System.out.println(s);
        }

        // Check if a student exists
        boolean exists = studentSet.contains(new SetStudent("S002", "Bob"));
        System.out.println("Bob exists? " + exists); // true

        // Remove a student
        studentSet.remove(new SetStudent("S003", "Charlie"));
    }
}
