package com.rf.khan.api.iq.array.twoD;

import java.util.ArrayList;
import java.util.List;

public class SpiralPrint54LC {

	public static void main(String[] args) {
		int[][] arr = { { 3, 4, 11 }, { 2, 12, 1 }, { 7, 8, 7 } };
		int row = arr.length;
		int col = arr[0].length;
		printArray(arr, row, col);
		System.out.println("________________________________");
		System.out.println(spiralOrder(arr));
		int[][] senc = new int[0][0];
		System.out.println(spiralOrder(senc));

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

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ansList = new ArrayList<Integer>();

		int rowSize = matrix.length;
		int colSize = 0;
		if (rowSize != 0) {
			colSize = matrix[0].length;
		}

		int count = 0;
		int totalSize = rowSize * colSize;

		// index initialization
		int startingRow = 0;
		int startingcolumn = 0;
		int endingRow = rowSize - 1;
		int endingColumn = colSize - 1;

		// to check where i am not repeating same round

		while (count < totalSize) {
			// printing starting row
			for (int index = startingcolumn; count < totalSize && index <= endingColumn; index++) {
				ansList.add(matrix[startingRow][index]);
				count++;
			}
			startingRow++;

			// printing ending column
			for (int index = startingRow; count < totalSize && index <= endingRow; index++) {
				ansList.add(matrix[index][endingColumn]);
				count++;
			}
			endingColumn--;

			// printing ending row
			for (int index = endingColumn; count < totalSize && index >= startingcolumn; index--) {
				ansList.add(matrix[endingRow][index]);
				count++;
			}

			endingRow--;

			// printing staring column
			for (int index = endingRow; count < totalSize && index >= startingRow; index--) {
				ansList.add(matrix[index][startingcolumn]);
				count++;
			}
			startingcolumn++;
		}
		return ansList;
	}

}
