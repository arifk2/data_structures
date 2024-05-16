package com.rf.khan.api.iq.graph.striver;

import java.util.Arrays;
import java.util.PriorityQueue;

public class G37PathWithMinimumEffort {
	public static void main(String[] args) {
		int[][] heights = { { 1, 2, 3 }, { 3, 8, 2 }, { 5, 3, 5 } };
		G37PathWithMinimumEffort g = new G37PathWithMinimumEffort();
		System.out.println(g.minimumEffortPath(heights));
	}

	public int minimumEffortPath(int[][] heights) {

		int n = heights.length;
		int m = heights[0].length;
		int[][] distance = new int[n][m];

		// create priority queue of type tuple in sorting manner
		PriorityQueue<Tupple> pq = new PriorityQueue<Tupple>((x, y) -> x.distance - y.distance);

		// Step 1: create a distance array and fill with 1e9(infinity)
		for (int[] arr : distance)
			Arrays.fill(arr, (int) 1e9);

		// Step 2: source will be 0,0 and distance also will be 0 and also insert the a
		distance[0][0] = 0;
		pq.add(new Tupple(0, 0, 0));

		int[] dR = { -1, 0, 1, 0 };
		int[] dC = { 0, 1, 0, -1 };

		while (!pq.isEmpty()) {
			Tupple it = pq.poll();
			
			int diff = it.distance;
			int row = it.row;
			int col = it.column;

			if (row == n - 1 && col == m - 1)
				return diff;

			// row-1, col
			// row, col+1
			// row-1, col
			// row, col-1
			for (int i = 0; i < 4; i++) {
				int newR = row + dR[i];
				int newC = col + dC[i];

				if (newR >= 0 && newC >= 0 && newR < n && newC < m) {
					int newEffort = Math.max(Math.abs(heights[row][col] - heights[newR][newC]), diff);
					if (newEffort < distance[newR][newC]) {
						distance[newR][newC] = newEffort;
						pq.add(new Tupple(newEffort, newR, newC));
					}
				}
			}
		}
		return -1;
	}

	class Tupple {
		int distance;
		int row;
		int column;

		public Tupple(int distance, int row, int column) {
			this.distance = distance;
			this.row = row;
			this.column = column;
		}
	}
}
