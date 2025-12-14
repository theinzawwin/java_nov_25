package com.pearl.novdev.fileio;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentMapFileApp {

    static final String FILE_NAME = "map_students.txt";
    static Map<String, StudentForMap> studentMap = new HashMap<>();
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner input = new Scanner(System.in);
        loadFromFile();

        int choice;
        do {
            System.out.println("\n=== Student Management Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. Search by ID");
            System.out.println("3. Delete by ID");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1 -> addStudent(input);
                case 2 -> searchStudent(input);
                case 3 -> deleteStudent(input);
                case 4 -> listAllStudents();
                case 5 -> {
                    saveToFile();
                    System.out.println("Data saved. Goodbye!");
                }
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    static void addStudent(Scanner input) {
        System.out.print("Enter ID: ");
        String id = input.nextLine();
        if (studentMap.containsKey(id)) {
            System.out.println("Student with this ID already exists!");
            return;
        }
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(input.nextLine());
        System.out.print("Grade: ");
        double grade = Double.parseDouble(input.nextLine());
        System.out.print("Address: ");
        String address = input.nextLine();

        StudentForMap s = new StudentForMap(id, name, age, grade, address);
        studentMap.put(id, s);
        System.out.println("Student added.");
    }

    static void searchStudent(Scanner input) {
        System.out.print("Enter Student ID to search: ");
        String id = input.nextLine();
        StudentForMap s = studentMap.get(id);
        if (s != null) s.display();
        else System.out.println("Student not found.");
    }

    static void deleteStudent(Scanner input) {
        System.out.print("Enter Student ID to delete: ");
        String id = input.nextLine();
        if (studentMap.remove(id) != null)
            System.out.println("Student deleted.");
        else
            System.out.println("ID not found.");
    }

    static void listAllStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("No students in the list.");
            return;
        }
        System.out.println("\n-- All Students --");
        studentMap.values().forEach(StudentForMap::display);
    }

    static void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StudentForMap s = StudentForMap.fromString(line);
                studentMap.put(s.id, s);
            }
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    static void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (StudentForMap s : studentMap.values()) {
                writer.write(s.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
