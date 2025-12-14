package com.pearl.novdev.collection;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {

    public static void main(String[] args) {
        Set<TreeSetStudent> students = new TreeSet<>();
        //Set<TreeSetStudent> students = new TreeSet<>(Comparator.comparing(s -> s.id));
        students.add(new TreeSetStudent("S003", "Charlie"));
        students.add(new TreeSetStudent("S001", "Alice"));
        students.add(new TreeSetStudent("S002", "Bob"));
        students.add(new TreeSetStudent("S001", "Alice")); // Duplicate ID, will be ignored

        System.out.println("Students sorted by name:");
        for (TreeSetStudent s : students) {
            System.out.println(s);
        }
    }

}
