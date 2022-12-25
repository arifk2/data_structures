package com.rf.khan.api.coding.decoded;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInGridObstacleEliminationLC1293 {

	public static void main(String[] args) {
		ShortestPathInGridObstacleEliminationLC1293 s = new ShortestPathInGridObstacleEliminationLC1293();
		System.out.println(
				s.shortestPath(new int[][] { { 0, 0, 0 }, { 1, 1, 0 }, { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0, 0 } }, 1));
	}

	private int[][] dir = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	public int shortestPath(int[][] grid, int k) {
		int m = grid.length;
		int n = grid[0].length;

		if (m == 0 || n == 0)
			return 0;

		// minimum obstacle encounter at each cell
		int[][] obstacles = new int[m][n];

		boolean[][] visited = new boolean[m][n];

		Queue<int[]> queue = new LinkedList<>();

		// x, y obstacle count
		queue.add(new int[] { 0, 0, grid[0][0] });
		obstacles[0][0] = grid[0][0];

		int level = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int[] head = queue.poll();
				if (head[0] == m - 1 && head[1] == n - 1) {
					return level - 1;
				}
				// head node, this is obstacle count
				int currObstacleCount = head[2];
				for (int[] d : dir) {
					int x = head[0] + d[0];
					int y = head[1] + d[1];

					// within limits
					if (!(x >= 0 && y >= 0 && x < m && y < n))
						continue;

					int oldObstacleCount = obstacles[x][y];
					int newObstacleCount = currObstacleCount + grid[x][y];

					if ((!visited[x][y]) && newObstacleCount <= k) {
						queue.add(new int[] { x, y, newObstacleCount });
						obstacles[x][y] = newObstacleCount;
						visited[x][y] = true;
					}

					if ((oldObstacleCount > newObstacleCount) && newObstacleCount <= k) {
						queue.add(new int[] { x, y, newObstacleCount });
						obstacles[x][y] = newObstacleCount;
						visited[x][y] = true;
					}
				}
			}
			level++;
		}
		return -1;
	}
}
