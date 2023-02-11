package com.rf.khan.api.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class FarLandPossibleLC1162 {

	public static void main(String[] args) {
		FarLandPossibleLC1162 f = new FarLandPossibleLC1162();
		System.out.println(f.maxDistance(new int[][] { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } }));
		System.out.println(f.maxDistance(new int[][] { { 1, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }));
	}

	public int maxDistance(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		boolean[][] visited = new boolean[row][col];

		return bfs(grid, visited, row, col);
	}

	private int bfs(int[][] grid, boolean[][] visited, int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		// Get all four directions
		int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		int maxDistance = -1;

		// check for all the lands present in the grid
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 1) {
					visited[i][j] = true;
					queue.offer(new int[] { i, j });
				}
			}
		}

		// bfs traversal
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int[] current = queue.poll();
				int x = current[0];
				int y = current[1];

				for (int[] dir : directions) {
					int newX = x + dir[0];
					int newY = y + dir[1];
					if (newX < 0 || newX >= row || newY < 0 || newY >= col || visited[newX][newY]) {
						continue;
					}
					visited[newX][newY] = true;
					grid[newX][newY] = grid[x][y] + 1;
					maxDistance = Math.max(maxDistance, grid[newX][newY]);
					queue.add(new int[] { newX, newY });
				}
			}
		}
		return maxDistance < 0 ? -1 : maxDistance - 1;
	}
}
