package com.pearl.novdev.oop;
class Student {
    String name;
    int age;
    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    void show(){
        System.out.println(name+" - "+age);
    }
}
public class ClassDemo {
    public static void main(String[] args){
        Student s =new Student("Mg Mg",30);
       // s.name = "Mg Mg";
       // s.age = 30;
        s.show();
    }
}
