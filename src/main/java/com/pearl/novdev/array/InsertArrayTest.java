package com.pearl.novdev.array;

import java.util.Arrays;

public class InsertArrayTest {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        int newElement = 10;
        int position = 2;

        // Shift elements
        for (int i = arr.length - 1; i > position; i--) {
            arr[i] = arr[i - 1];
        }

    // Insert new element
        arr[position] = newElement;
        System.out.println("After inserting=> "+ Arrays.toString(arr));
    }
}
