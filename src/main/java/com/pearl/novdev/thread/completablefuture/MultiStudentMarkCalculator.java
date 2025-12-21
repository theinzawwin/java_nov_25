package com.pearl.novdev.thread.completablefuture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

class Student {
    String name;
    public Student(String name) {
        this.name = name;
    }
}
public class MultiStudentMarkCalculator {

    public static CompletableFuture<Integer> getSubjectMark(String subject, String studentName) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300 + (int)(Math.random() * 400)); // simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int mark = 60 + (int)(Math.random() * 40); // 60 to 100
            System.out.println(studentName + " got " + mark + " in " + subject);
            return mark;
        });
    }

    public static CompletableFuture<Void> calculateStudentMarks(Student student) {
        CompletableFuture<Integer> math = getSubjectMark("Math", student.name);
        CompletableFuture<Integer> science = getSubjectMark("Science", student.name);
        CompletableFuture<Integer> english = getSubjectMark("English", student.name);

        return math.thenCombine(science, Integer::sum)
                .thenCombine(english, Integer::sum)
                .thenAccept(total -> {
                    double avg = total / 3.0;
                    System.out.println(">> " + student.name + " Total: " + total + ", Average: " + avg);
                });
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Student> students = Arrays.asList(
                new Student("Alice"),
                new Student("Bob"),
                new Student("Charlie")
        );

        // List of all futures for each student
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (Student s : students) {
            futures.add(calculateStudentMarks(s));
        }

        // Wait for all students to complete
        CompletableFuture<Void> allDone = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allDone.join(); // block until all are done

        System.out.println("All students' marks processed.");
    }

}
