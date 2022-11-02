package com.rf.khan.api.conding.decoded;

import java.util.Arrays;

public class WherewillTheBallFallLC1706 {
	public static void main(String[] args) {
		// int[][] grid = { { 1, 1, 1, -1, -1 }, { 1, 1, 1, -1, -1 }, { -1, -1, -1, 1, 1
		// }, { 1, 1, 1, 1, -1 },
		// { -1, -1, -1, -1, -1 } };

		int[][] grid = { { -1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 1, 1, -1, -1, -1, 1, 1, 1, -1, -1, 1, 1,
				-1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, 1, -1,
				1, -1, -1, 1, 1, -1, 1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, -1, 1, 1, 1, -1, -1, -1, 1, -1,
				1, -1, -1, 1, 1, -1, -1, 1, -1, 1, -1, 1, 1, 1, -1, -1, -1, -1 } };

		WherewillTheBallFallLC1706 w = new WherewillTheBallFallLC1706();
		int[] ans = w.findBall(grid);

		Arrays.stream(ans).forEach(System.out::print);

	}

	public int[] findBall(int[][] grid) {
		int colL = grid[0].length;

		int[] ans = new int[colL];
		Arrays.fill(ans, -1);

		for (int col = 0; col < colL; col++) {
			dfs(0, col, grid, col, ans);
		}
		return ans;
	}

	private void dfs(int row, int col, int[][] grid, int startingIndex, int[] ans) {
		if (row == grid.length) {
			ans[startingIndex] = col;
			return;
		}

		if (grid[row][col] == 1) {
			// check right cell
			if (col + 1 < grid[0].length && grid[row][col + 1] == 1)
				dfs(row + 1, col + 1, grid, startingIndex, ans); // right diagonal move
		} else if (grid[row][col] == -1) {
			if (col - 1 >= 0 && grid[row][col - 1] == -1)
				dfs(row + 1, col - 1, grid, startingIndex, ans); // left diagonal move
		}
	}
}
