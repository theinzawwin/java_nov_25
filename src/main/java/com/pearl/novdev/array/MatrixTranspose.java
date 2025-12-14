package com.pearl.novdev.array;

public class MatrixTranspose {
    public void show(){
        System.out.println("Hello");
    }
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] transpose = new int[cols][rows];

        // Perform transpose
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        // Display result
        System.out.println("Transpose Matrix:");
        for (int[] row : transpose) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    public static int[][] transposeMatrix(int[][] arr){
        int[][] transposeMatrix = new int[arr[0].length][arr.length];

        return transposeMatrix;
    }
}
