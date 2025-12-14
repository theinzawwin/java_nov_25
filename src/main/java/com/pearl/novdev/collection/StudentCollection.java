package com.pearl.novdev.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentCollection {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student by ID");
            System.out.println("3. Search Student by Name");
            System.out.println("4. Display All Students");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    students.add(new Student(id, name, age));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter ID to delete: ");
                    String deleteId = scanner.nextLine();
                    boolean removed = students.removeIf(s -> s.id.equals(deleteId));
                    if (removed) {
                        System.out.println("Student deleted.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine().toLowerCase();
                    List<Student> found = students.stream()
                            .filter(s -> s.name.toLowerCase().contains(searchName))
                            .toList();
                    if (found.isEmpty()) {
                        System.out.println("No student found.");
                    } else {
                        found.forEach(System.out::println);
                    }
                    break;

                case 4:
                    if (students.isEmpty()) {
                        System.out.println("No students in the list.");
                    } else {
                        System.out.println("Student List:");
                        students.forEach(System.out::println);
                    }
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
