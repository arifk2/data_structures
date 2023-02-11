package com.rf.khan.api.leetcode;

public class UniquePathIILC980 {
	public static void main(String[] args) {
		int[][] grid = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
		UniquePathIILC980 u = new UniquePathIILC980();
		System.out.println(u.uniquePathsIII(grid));
	}

	public int uniquePathsIII(int[][] grid) {
		int zeroCount = 0;
		int sX = 0; // starting x axis
		int sY = 0;// starting y axis

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == 0)
					zeroCount++;
				else if (grid[row][col] == 1) {
					sX = row;
					sY = col;
				}
			}
		}
		return dfs(grid, sX, sY, zeroCount);
	}

	private int dfs(int[][] grid, int row, int col, int zeroCount) {
		// base case

		// i) check for the out-bound condition and visited
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == -1)
			return 0;
		// ii) if the robot reached at destination 2 or any zero is still remaining.
		if (grid[row][col] == 2)
			return zeroCount == -1 ? 1 : 0;

		// mark visited
		grid[row][col] = -1;
		// decrease zeroCount
		zeroCount--;

		int totalPaths = dfs(grid, row + 1, col, zeroCount) + dfs(grid, row - 1, col, zeroCount)
				+ dfs(grid, row, col - 1, zeroCount) + dfs(grid, row, col + 1, zeroCount);

		// backtracking
		grid[row][col] = 0;
		zeroCount++;

		return totalPaths;
	}
}
