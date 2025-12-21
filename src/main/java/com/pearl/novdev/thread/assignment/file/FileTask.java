package com.pearl.novdev.thread.assignment.file;

import java.io.*;
import java.util.concurrent.Callable;

public class FileTask implements Callable<Integer> {
    private File file;

    public FileTask(File file) {
        this.file = file;
    }

    @Override
    public Integer call() throws Exception {
        int words = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                words += line.split("\\s+").length;
            }
        }
        System.out.println(file.getName() + " → words: " + words);
        return words;
    }
}