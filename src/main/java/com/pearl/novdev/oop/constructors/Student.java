package com.pearl.novdev.oop.constructors;

public class Student {

    {
        System.out.println("1. In Initializer Block");
    }

    static {
        System.out.println("1. In Static Class Initializer Block");
    }
    String name;
    int age;

    // no-args constructor
    Student() {
        System.out.println("2. In Constructor");
        this.name = "Unknown";
        this.age = 0;
    }

    // parameterized constructor having one parameter
    Student(String name) {
        System.out.println("2. In Constructor, Name");
        this.name = name;
        this.age = 0;
    }

    // parameterized constructor having both parameters
    Student(String name, int age) {
        System.out.println("2. In Constructor Name, Age");
        this.name = name;
        this.age = age;
    }

    public void printDetails() {
        System.out.println("Name : " + this.name);
        System.out.println("Age : " + this.age);
    }
}
