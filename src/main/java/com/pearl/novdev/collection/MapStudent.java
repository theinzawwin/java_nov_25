package com.pearl.novdev.collection;

public class MapStudent {
    String name;
    int age;
    double grade;

    MapStudent(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return name + " (Age: " + age + ", Grade: " + grade + ")";
    }
}
