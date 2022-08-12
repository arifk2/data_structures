package com.rf.khan.api.backtracking;

public class SudokuSolver {
	public static void solveSudoku(int[][] sudoku) {
		solve(sudoku);

	}

	/**
	 * Recursive method
	 * 
	 * @param sudoku
	 * @return
	 */
	private static boolean solve(int[][] sudoku) {
		int n = sudoku[0].length;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {

				// check for the empty
				if (sudoku[row][col] == 0) {
					for (int val = 0; val <= 9; val++) {
						if (isSafe(row, col, sudoku, val, n)) {
							sudoku[row][col] = val;

							// recursive call
							boolean isNextPossibleSolution = solve(sudoku);
							if (isNextPossibleSolution)
								return true;
							else {

								// backtrack
								sudoku[row][col] = 0;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * This is a safe method which will tell that the row , column and 3* matrix is
	 * safe to put or not
	 * 
	 * @param row    holds the information of the row
	 * @param col    holds the information of the column
	 * @param sudoku holds the information of the 2D array
	 * @param value  holds the information of the value
	 * @param n      holds the size of the array
	 * @return true/false
	 */
	private static boolean isSafe(int row, int col, int[][] sudoku, int value, int n) {
		for (int i = 0; i < n; i++) {
			// row check
			if (sudoku[row][i] == value)
				return false;

			// column check
			if (sudoku[i][col] == value)
				return false;

			// check for the 3*3 matrix
			if (sudoku[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == value)
				return false;

		}
		return true;
	}

	/**
	 * Driver method for the input
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] sudoku = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		solve(sudoku);

		for (int i = 0; i < sudoku[0].length; i++) {
			for (int j = 0; j < sudoku[0].length; j++) {
				System.out.print(sudoku[i][j] + " ");
			}
			System.out.println();
		}
	}
}
