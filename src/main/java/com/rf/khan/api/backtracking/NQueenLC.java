package com.rf.khan.api.backtracking;

import java.util.ArrayList;
import java.util.List;

class NQueenLC {
	public List<List<String>> solveNQueens(int n) {

		List<List<String>> ans = new ArrayList<>();
		String[][] board = new String[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = ".";
			}
		}

		solve(0, board, ans, n);

		return ans;
	}

	private void solve(int col, String[][] board, List<List<String>> ans, int n) {
		if (col == n) {
			addSolution(board, ans, n);
			return;
		}

		for (int row = 0; row < n; row++) {
			if (isSafe(row, col, board, n)) {
				board[row][col] = "Q";
				solve(col + 1, board, ans, n);
				// bt
				board[row][col] = ".";
			}
		}
	}

	private boolean isSafe(int row, int col, String[][] board, int n) {
		int x = row;
		int y = col;

		// check for the same row
		while (y >= 0) {
			if (board[x][y].equals("Q"))
				return false;
			y--;
		}

		x = row;
		y = col;
		// check for diagonal(top)
		while (x >= 0 && y >= 0) {

			if (board[x][y].equals("Q"))
				return false;
			x--;
			y--;
		}

		x = row;
		y = col;

		// check for diagonal(down)
		while (x < n && y >= 0) {

			if (board[x][y].equals("Q"))
				return false;
			x++;
			y--;
		}

		return true;
	}

	private void addSolution(String[][] board, List<List<String>> ans, int n) {
		List<String> temp = new ArrayList<String>();
		String str = "";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// temp.add(board[i][j]);
				str += board[i][j];
			}
			temp.add(str);
			str = "";
		}
		ans.add(temp);
	}

	public static void main(String[] args) {
		NQueenLC s = new NQueenLC();
		System.out.println(s.solveNQueens(4));
	}

}