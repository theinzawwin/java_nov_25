package com.pearl.novdev.array;

public class DeleteArray {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        int position = 2;

        // Shift elements
        for (int i = position; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        // Update last element
        arr[arr.length - 1] = 0; // Or any default value
    }
}
