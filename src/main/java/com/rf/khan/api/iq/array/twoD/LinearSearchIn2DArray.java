package com.rf.khan.api.iq.array.twoD;

public class LinearSearchIn2DArray {
	public static void main(String[] args) {

		int[][] arr = new int[3][4];
		int count = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				arr[i][j] = count++;
			}
		}
		printArray(arr, 3, 4);
		System.out.println("Is the target Number is present in the 3D array: " + linearSearch(arr, 3, 4, 6));

	}

	public static boolean linearSearch(int[][] arr, int row, int col, int targetNumber) {
		int i = 0, j = 0;
		for (i = 0; i < row; i++) {
			for (j = 0; j < col; j++) {
				if (arr[i][j] == targetNumber) {
					return true;
				}
			}
		}
		return false;
	}

	public static void printArray(int[][] arr, int row, int col) {
		System.out.println("row: " + arr.length);
		System.out.println("col: " + arr[0].length);
		int i = 0, j = 0;
		for (i = 0; i < row; i++) {
			for (j = 0; j < col; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		/*
		 * System.out.println(); for (int[] in : arr) {
		 * System.out.println(Arrays.toString(in)); }
		 */
	}
}
