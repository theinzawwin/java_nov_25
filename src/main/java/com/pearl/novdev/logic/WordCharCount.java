package com.pearl.novdev.logic;

import java.util.Scanner;

public class WordCharCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine().trim();

        String[] words = sentence.split("\\s+");
        int charCount = sentence.replace(" ", "").length();

        System.out.println("Total words: " + words.length);
        System.out.println("Total characters: " + charCount);
    }
}
