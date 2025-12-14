package com.pearl.novdev.oop.hospital.model;

public class Patient extends Person {
    private String sickness;

    public Patient(String name, int age, String sickness) {
        super(name, age);
        this.sickness = sickness;
    }

    public String getSickness() { return sickness; }

    @Override
    public void printInfo() {
        System.out.println("Patient: " + getName() + " (" + getAge() + ") - Sickness: " + sickness);
    }
}