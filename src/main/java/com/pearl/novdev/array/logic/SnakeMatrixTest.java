package com.pearl.novdev.array.logic;

public class SnakeMatrixTest {

    public static void main(String[] args){
        int[][] two = new int[5][5];
        int val = 1;
        for (int row = two.length-1; row >=0; row--){
            if(row%2 ==0 ){
                for (int col = two[0].length-1; col >=0; col--){
                    two[row][col] = val++;
                }
            } else{
                for (int col=0; col < two[0].length; col++){
                    two[row][col] = val++;
                }
            }

        }
        // Print the array
        for (int row = 0; row < two.length; row++){
            for (int col=0; col<two[0].length; col++){
                System.out.print(two[row][col] + "\t");
            }
            System.out.println();
        }
    }
}
