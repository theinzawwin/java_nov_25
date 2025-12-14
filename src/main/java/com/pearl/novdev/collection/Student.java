package com.pearl.novdev.collection;

public class Student {

    String id;
    String name;
    int age;

    Student(String name){
        this.name=name;
    }
    Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "[" + id + "] " + name + " (" + age + " years)";
    }
}
