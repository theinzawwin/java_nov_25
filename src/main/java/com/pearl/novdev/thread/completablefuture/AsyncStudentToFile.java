package com.pearl.novdev.thread.completablefuture;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class StudentAsync {
    String name;
    public StudentAsync(String name) {
        this.name = name;
    }
}
public class AsyncStudentToFile {

    static ExecutorService executor = Executors.newFixedThreadPool(3); // 3 parallel threads
    static final String OUTPUT_FILE = "student_results.txt";

    public static CompletableFuture<Integer> getSubjectMark(String subject, String studentName) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300 + (int)(Math.random() * 400));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int mark = 60 + (int)(Math.random() * 40);
            System.out.println(studentName + " got " + mark + " in " + subject);
            return mark;
        }, executor);
    }

    public static CompletableFuture<Void> calculateAndSave(StudentAsync student) {
        CompletableFuture<Integer> math = getSubjectMark("Math", student.name);
        CompletableFuture<Integer> science = getSubjectMark("Science", student.name);
        CompletableFuture<Integer> english = getSubjectMark("English", student.name);

        return math.thenCombine(science, Integer::sum)
                .thenCombine(english, Integer::sum)
                .thenAccept(total -> {
                    double avg = total / 3.0;
                    String result = student.name + " Total: " + total + ", Average: " + avg;

                    System.out.println(">> " + result);
                    appendToFile(result);
                });
    }

    public static CompletableFuture<Void> calculateAndSaveInCSV(StudentAsync student) {
        CompletableFuture<Integer> math = getSubjectMark("Math", student.name);
        CompletableFuture<Integer> science = getSubjectMark("Science", student.name);
        CompletableFuture<Integer> english = getSubjectMark("English", student.name);

        return math.thenCombine(science, (m, s) -> new int[]{m, s})
                .thenCombine(english, (ms, e) -> new int[]{ms[0], ms[1], e})
                .thenAccept(marks -> {
                    int mathMark = marks[0];
                    int scienceMark = marks[1];
                    int englishMark = marks[2];
                    int total = mathMark + scienceMark + englishMark;
                    double avg = total / 3.0;

                    System.out.printf(">> %s Total: %d, Average: %.2f%n", student.name, total, avg);
                    appendToCSV(student.name, mathMark, scienceMark, englishMark, total, avg);
                });
    }
    public static synchronized void appendToFile(String line) {
        try (FileWriter fw = new FileWriter(OUTPUT_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        List<StudentAsync> students = Arrays.asList(
                new StudentAsync("Alice"),
                new StudentAsync("Bob"),
                new StudentAsync("Charlie")
        );

        // Clear previous file
        try (PrintWriter pw = new PrintWriter(OUTPUT_FILE)) {
            pw.print("");  // Clear contents
        } catch (IOException e) {
            e.printStackTrace();
        }

        //try (PrintWriter pw = new PrintWriter("student_results.csv")) {
        //pw.println("Name,Math,Science,English,Total,Average");
        //} catch (IOException e) {
        //e.printStackTrace();
        //}
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (StudentAsync s : students) {
            futures.add(calculateAndSave(s));
        }

        CompletableFuture<Void> allDone = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allDone.join();

        executor.shutdown();
        System.out.println("All student marks saved to file.");
    }

    public static synchronized void appendToCSV(String name, int math, int science, int english, int total, double avg) {
        try (FileWriter fw = new FileWriter("student_results.csv", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.printf("%s,%d,%d,%d,%d,%.2f%n", name, math, science, english, total, avg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

