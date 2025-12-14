package com.pearl.novdev.fileio;

public class StudentForMap {

    String id, name, address;
    int age;
    double grade;

    StudentForMap(String id, String name, int age, double grade, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.address = address;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + grade + "," + address;
    }

    public static StudentForMap fromString(String line) {
        String[] parts = line.split(",", 5); // Address may contain commas
        return new StudentForMap(parts[0], parts[1], Integer.parseInt(parts[2]),
                Double.parseDouble(parts[3]), parts[4]);
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age +
                ", Grade: " + grade + ", Address: " + address);
    }
}
