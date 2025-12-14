package com.pearl.novdev.fileio;

public class StudentWithSerialize {

    private static final long serialVersionUID = 1L;
    String name;
    int age;
    double grade;

    public StudentWithSerialize(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age + ", Grade: " + grade);
    }
}
