package com.pearl.novdev.exception.sample;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);
        String file = "students.txt";

        service.load(file);

        while (true) {
            System.out.println("\n1.Add  2.Remove  3.Search  4.List  5.Save  0.Exit");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        System.out.print("Name: ");
                        String name = sc.next();
                        System.out.print("Marks: ");
                        int marks = sc.nextInt();
                        service.addStudent(new Student(id, name, marks));
                        break;

                    case 2:
                        System.out.print("Enter ID to remove: ");
                        service.removeStudent(sc.nextInt());
                        break;

                    case 3:
                        System.out.print("Enter ID to search: ");
                        System.out.println(service.findStudent(sc.nextInt()));
                        break;

                    case 4:
                        service.printAll();
                        break;

                    case 5:
                        service.save(file);
                        System.out.println("Saved to file.");
                        break;

                    case 0:
                        service.save(file);
                        System.exit(0);
                }
            } catch (StudentNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
