package com.pearl.novdev.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CommonExceptionDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // Runtime Exception Example (Unchecked)
        try {
            int[] numbers = {1, 2, 3};
            System.out.println("Accessing 5th element: " + numbers[4]); // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Runtime Exception: " + e.getMessage());

        }


        // Checked Exception Example
       try {
            BufferedReader reader = new BufferedReader(new FileReader("nonexistent_file.txt")); // FileNotFoundException
            String line = reader.readLine();
            System.out.println("Read line: " + line);
            reader.close();
        } catch (IOException e) { // Handles both FileNotFoundException and IOException
            System.out.println("Checked Exception: " + e.getMessage());
        }

        // Another Runtime Exception (ArithmeticException)
        try {
            int result = 10 / 0; // Division by zero
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Runtime Exception: " + e.getMessage());
        }

        System.out.println("Program completed.");
    }
}
