package com.pearl.novdev.fileio;

import java.io.File;

public class FolderMainApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        File folder = new File("MyFolder");

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null && files.length > 0) {
                System.out.println("Files in folder:");
                for (File f : files) {
                    System.out.println(f.getName());
                }
            } else {
                System.out.println("Folder is empty.");
            }
        } else {
            System.out.println("Folder does not exist.");
            folder.mkdir();
        }
    }

    static void deleteFolder() {
        File folder = new File("MyFolder");

        if (folder.exists() && folder.isDirectory()) {
            boolean deleted = folder.delete(); // Only deletes if empty
            System.out.println(deleted ? "Folder deleted." : "Failed to delete (not empty?)");
        } else {
            System.out.println("Folder does not exist.");
        }
    }


}
