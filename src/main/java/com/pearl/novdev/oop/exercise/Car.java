package com.pearl.novdev.oop.exercise;

public class Car extends Vehicle{

    private int doorCount;

    @Override
    public void move() {
        super.move();
        System.out.println(getBrand()+ " -Car is moving");
    }

    public Car(String brandName, int speed, int doorCount){
        super(brandName,speed);
        this.doorCount = doorCount;
    }

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }
}
