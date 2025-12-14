package com.pearl.novdev.oop.exercise;

public class AnimalMainTest {

    public static void main(String[] args){
        Animal[] animals = {
                new Dog(),
                new Cat(),
                new Cow(),
                new Sheep()
        };
        for(Animal animal : animals ){
            animal.sound();
        }
    }
}
