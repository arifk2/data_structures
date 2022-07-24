package com.rf.khan.api.iq.binary.search;

public class BinarySearchIn2D {

	public static void main(String[] args) {
		int[][] arr = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		int row = arr.length;
		int col = arr[0].length;
		printArray(arr, row, col);
		System.out.println("________________________________");
		System.out.println(searchMatrix(arr, 100));

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

	public static boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length;
		int col = matrix[0].length;

		int start = 0;
		int end = row * col - 1;

		int mid = start + (end - start) / 2;

		while (start <= end) {
			int element = matrix[mid / col][mid % col];

			if (element == target) {
				return true;
			}
			if (element < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			mid = start + (end - start) / 2;
		}

		return false;
	}

}
