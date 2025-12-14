package com.pearl.novdev.array;

public class SortArray {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 3};

        for (int i = 0; i < arr.length - 1; i++) {
            int innerArrLen =  arr.length - i - 1;
            for (int j = 0; j <innerArrLen; j++) {
                int big= arr[j];
                int small = arr[j + 1];
                if ( big> small) {
                    int temp = arr[j];
                    arr[j] = small;
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.print("Sorted Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
