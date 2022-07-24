package com.rf.khan.api.iq.array.twoD;

import java.util.ArrayList;

public class WavePrintCS49 {
	public static void main(String[] args) {
		int[][] arr = { { 3, 4, 11 }, { 2, 12, 1 }, { 7, 8, 7 } };
		int row = arr.length;
		int col = arr[0].length;
		printArray(arr, row, col);
		int[] arrt = wavePrint(arr, row, col);
		System.out.println();
		for (int i : arrt) {
			System.out.print(i + " ");
		}

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

	public static int[] wavePrint(int arr[][], int nRows, int mCols) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int column = 0; column < mCols; column++) {
			if (column % 2 == 0) {
				// even means top to bottom
				for (int rows = 0; rows < nRows; rows++) {
					System.out.print(arr[rows][column] + " ");
					list.add(arr[rows][column]);
				}
			} else {
				// odd - means bottom to top
				for (int rows = nRows - 1; rows >= 0; rows--) {
					System.out.print(arr[rows][column] + " ");
					list.add(arr[rows][column]);
				}
			}
		}
		
		int[] ans = list.stream().mapToInt(i -> i).toArray();
		return ans;
	}
}
