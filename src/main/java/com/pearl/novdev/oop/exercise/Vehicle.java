package com.pearl.novdev.oop.exercise;

public class Vehicle {
    private String brand;
    private Integer speed;
    public Vehicle(String brand, Integer speed){
        this.brand = brand;
        this.speed = speed;
    }
    public void move(){
        System.out.println("Vehicle is moving");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
}
