package com.rf.khan.api.backtracking;

import java.util.ArrayList;

public class NQueenProblem {
	public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
		// create a board
		int[][] board = new int[n][n];
		// answer
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		solve(0, board, ans, n);
		return ans;
	}

	/**
	 * Recursive method
	 * 
	 * @param col
	 * @param board
	 * @param ans
	 * @param n
	 */
	private static void solve(int col, int[][] board, ArrayList<ArrayList<Integer>> ans, int n) {
		// base case
		if (col == n) {
			// insert the board matrix into the ans
			// board solution insert into ans
			addSolution(board, ans, n);
			return;
		}

		// solve 1 case and rest recursion will do
		for (int row = 0; row < n; row++) {
			if (isSafe(row, col, board, n)) {
				// if placing queen is safe
				board[row][col] = 1;
				solve(col + 1, board, ans, n);

				// backtrack
				board[row][col] = 0;
			}
		}
	}

	/**
	 * This is a isSafe method so that it will tell whether to safe to place queen
	 * 
	 * @param row   holds the information of the row
	 * @param col   holds the information of the column
	 * @param board holds the information of the board
	 * @param n     size of the board
	 * @return true/false
	 */
	private static boolean isSafe(int row, int col, int[][] board, int n) {
		int x = row;
		int y = col;

		// check for the same row
		while (y >= 0) {
			if (board[x][y] == 1)
				return false;
			y--;
		}

		x = row;
		y = col;
		// check for diagonal(top)
		while (x >= 0 && y >= 0) {

			if (board[x][y] == 1)
				return false;
			x--;
			y--;
		}

		x = row;
		y = col;

		// check for diagonal(down)
		while (x < n && y >= 0) {

			if (board[x][y] == 1)
				return false;
			x++;
			y--;
		}

		return true;
	}

	/**
	 * add the board information to the answer
	 * 
	 * @param board holds the board as a output
	 * @param ans   holds the information of the answer
	 * @param n     holds the size of the board
	 */
	private static void addSolution(int[][] board, ArrayList<ArrayList<Integer>> ans, int n) {
		ArrayList<Integer> temp = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp.add(board[i][j]);
			}
		}

		ans.add(temp);
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 4;
		System.out.println(solveNQueens(n));
	}
}
