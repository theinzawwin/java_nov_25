package com.pearl.novdev.fileio;

import java.io.*;

public class ObjectReadWriteDemo {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        readObjectFromFile();

       // writeObject();
    }

    static void writeObject() {
        StudentWithSerialize s = new StudentWithSerialize("Alice", 20, 88.5);

        try {
            FileOutputStream fileOut = new FileOutputStream("student.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(s);

            out.close();
            fileOut.close();
            System.out.println("Student object written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void readObjectFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream("student.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            StudentWithSerialize s = (StudentWithSerialize) in.readObject();  // type cast required
            s.display();

            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
