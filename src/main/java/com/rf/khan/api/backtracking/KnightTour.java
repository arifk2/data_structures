package com.rf.khan.api.backtracking;

public class KnightTour {
	static int N = 8;

	/**
	 * This is a driver method to solve the knight problem
	 * 
	 * @return true/false
	 */
	public static boolean solveKT() {
		int[][] board = new int[N][N];

		// initializing board matrix by -1;
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				board[row][col] = -1;
			}
		}

		// move of the knight and defined in the x and y coordinate
		int rowMoves[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int colMoves[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		// knight start from first block
		board[0][0] = 0;

		if (!isPossibleKT(0, 0, 1, board, rowMoves, colMoves)) {
			System.out.println("Solution does not possible");
			return false;
		} else {
			// print the solution
			printingSolution(board);
		}
		return true;
	}

	private static boolean isPossibleKT(int row, int col, int move, int[][] board, int[] rowMoves, int[] colMoves) {
		if (move == N * N)
			return true;

		int nextRow, nextCol;

		// try all the moves from the current coordinates
		for (int i = 0; i < N; i++) {
			nextRow = row + rowMoves[i];
			nextCol = col + colMoves[i];
			if (isSafe(nextRow, nextCol, board)) {
				board[nextRow][nextCol] = move;
				boolean isNextMovePossible = isPossibleKT(nextRow, nextCol, move + 1, board, rowMoves, colMoves);
				if (isNextMovePossible)
					return true;
				else
					// backtrack
					board[nextRow][nextCol] = -1;
			}
		}
		return false;
	}

	/**
	 * This method will check whether is safe to move next steps on the board
	 * 
	 * @param nextRow holds the information of the next row
	 * @param nextCol holds the information of the next col
	 * @param board   holds the information of the board
	 * @return true/false
	 */
	private static boolean isSafe(int nextRow, int nextCol, int[][] board) {
		return ((nextRow >= 0 && nextRow < N) && (nextCol >= 0 && nextCol < N) && board[nextRow][nextCol] == -1);
	}

	/**
	 * This method is created to print the solution
	 * 
	 * @param board holds the information of the board
	 */
	private static void printingSolution(int[][] board) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		solveKT();
	}
}
