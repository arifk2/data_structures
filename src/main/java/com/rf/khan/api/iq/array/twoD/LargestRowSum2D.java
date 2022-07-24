package com.rf.khan.api.iq.array.twoD;

public class LargestRowSum2D {

	public static void main(String[] args) {
		int[][] arr = { { 3, 4, 11 }, { 2, 12, 1 }, { 7, 8, 7 } };
		int row = arr.length;
		int col = arr[0].length;
		printArray(arr, row, col);
		
		System.out.println(printlargestRowSum(arr, row, col));

	}

	public static int printlargestRowSum(int[][] arr, int row, int col) {
		int max = Integer.MIN_VALUE;
		int rowIndex = 0;
		for (int i = 0; i < row; i++) {
			int sum = 0;
			for (int j = 0; j < col; j++) {
				sum += arr[i][j];
			}
			if (sum > max) {
				rowIndex = i;
			}
		}
		return rowIndex;
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
