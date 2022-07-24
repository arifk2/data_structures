package com.rf.khan.api.iq.array.twoD;

public class RotateImage2D {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int row = arr.length;
		int col = arr[0].length;
		printArray(arr, row, col);
		System.out.println("________________________________");

	}

	
	
	
	
	public static void printArray(int[][] arr, int row, int col) {
		System.out.println("********Printing 2D array********");
		int i = 0, j = 0;
		for (i = 0; i < row; i++) {
			for (j = 0; j < col; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("********Printing 2D array********");
	}

}
