package com.pearl.novdev.fileio;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FilePrintWriterDemoApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Student s1 = new Student("Alice", 20, 85.5);
        Student s2 = new Student("Bob", 21, 90.0);

        PrintWriter pw;
        try {
            pw = new PrintWriter("pw_students.txt");
            pw.printf("%s,%d,%.2f\n", s1.getName(), s1.getAge(), s1.getAge());
            pw.printf("%s,%d,%.2f\n", s2.getName(), s2.getAge(), s2.getGrade());

            pw.close();
            System.out.println("Student data written.");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        printWriterWithFileWriter();

    }

    static void printWriterWithFileWriter() {
        try {
            // Create FileWriter in append mode (true)
            FileWriter fw = new FileWriter("pw_students.txt", true);
            PrintWriter pw = new PrintWriter(fw);

            // Append new student record
            pw.printf("%s,%d,%.2f\n", "Charlie", 22, 78.5);
            pw.printf("%s,%d,%.2f\n", "Dana", 23, 92.0);

            pw.close();
            System.out.println("New student data appended.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
