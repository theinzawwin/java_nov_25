package com.pearl.novdev.array.logic;

public class SnailMatrixTest {

    public static void main(String[] args){
        int[][] two = new int[5][5];
        int val = 1;
        int row = 0;
        int col = -1;
        int move = 1;
        int max = 5;
        // Put the numbers in the array
        for(int i=0; i< 5; i++){
            for(int j = 0; j<max;j++){
                col = col+move;
                two[row][col] = val++;
            }
            max--;
            for(int j=0; j < max;j++){
                row = row+move;
                two[row][col] = val++;
            }
            move = move * -1;
        }

        // Print the array
        for(int i = 0; i<two.length; i++){
            for(int j = 0; j<two[0].length;j++){
                System.out.print(two[i][j]+"\t");
            }
            System.out.println();
        }

    }
}
