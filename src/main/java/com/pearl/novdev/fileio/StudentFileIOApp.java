package com.pearl.novdev.fileio;

import java.io.*;
import java.util.Scanner;

public class StudentFileIOApp {


    static final String FILE_NAME = "students.txt";
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Student File App ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search By Name");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = input.nextInt();
            input.nextLine(); // consume newline
            switch (choice) {
                case 1 -> addStudent(input);
                case 2 -> viewStudents();
                case 3 -> searchByName(input);
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    static void addStudent(Scanner input) throws IOException {
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Age: ");
        int age = input.nextInt();
        System.out.print("Grade: ");
        double grade = input.nextDouble();

        Student student = new Student(name, age, grade);

        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true)); // append mode
        writer.write(student.toString());
        writer.newLine();
        writer.close();

        System.out.println("Student added.");
    }

    static void viewStudents() throws IOException {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No student data found.");
            return;
        }

        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
        String line;
        System.out.println("\n-- Student List --");
        while ((line = reader.readLine()) != null) {
            Student s = Student.fromString(line);
            System.out.println("Name: " + s.getName() + ", Age: " + s.getAge() + ", Grade: " + s.getGrade());
        }
        reader.close();
    }
    static void searchByName(Scanner input) throws IOException {
        System.out.print("Enter name to search: ");
        String searchName = input.nextLine().toLowerCase();

        BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
        String line;
        boolean found = false;

        while ((line = reader.readLine()) != null) {
            Student s = Student.fromString(line);
            if (s.getName().toLowerCase().contains(searchName)) {
                s.display();
                found = true;
            }
        }
        reader.close();

        if (!found) {
            System.out.println("No student found with that name.");
        }
    }


}
