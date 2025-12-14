package com.pearl.novdev.exception.sample;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    public void load(String fileName) {
        students = FileService.loadFromFile(fileName);
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void removeStudent(int id) throws StudentNotFoundException {
        Student found = findStudent(id);
        students.remove(found);
    }

    public Student findStudent(int id) throws StudentNotFoundException {
        for (Student s : students) {
            if (s.getId() == id)
                return s;
        }
        throw new StudentNotFoundException("Student ID " + id + " not found");
    }

    public void printAll() {
        students.forEach(System.out::println);
    }

    public void save(String fileName) {
        FileService.saveToFile(fileName, students);
    }
}
