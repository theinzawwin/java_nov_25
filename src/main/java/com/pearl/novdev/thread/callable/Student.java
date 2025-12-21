package com.pearl.novdev.thread.callable;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private List<Integer> marks;

    public Student(int id, String name, List<Integer> marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getMarks() {
        return marks;
    }
}
