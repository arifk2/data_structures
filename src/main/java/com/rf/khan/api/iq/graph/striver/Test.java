package com.rf.khan.api.iq.graph.striver;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test {

	class Tupple {
		int first, second, third;

		public Tupple(int first, int second, int third) {
			this.first = first;
			this.second = second;
			this.third = third;
		}
	}

	public static void main(String[] args) {
		int[] source = { 0, 1 };
		int[] destination = { 2, 2 };

		int[][] grid = { { 1, 1, 1, 1 }, { 1, 1, 0, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 }, { 1, 0, 0, 1 } };

		G36ShortestDistanceBinaryMaze shortestDistanceBinaryMaze = new G36ShortestDistanceBinaryMaze();
		System.out.println(shortestDistanceBinaryMaze.shortestPath(grid, source, destination));
	}

	/**
	 * shortest path
	 * 
	 * @param grid        given grid 0 to no move, 1 to move, in all four direction
	 * @param source      source co-oridinates
	 * @param destination co-oridinates
	 * @return
	 */
	public int shortestPath(int[][] grid, int[] source, int[] destination) {

		if (source[0] == destination[0] && source[1] == destination[1])
			return 0;

		Queue<Tupple> q = new LinkedList<Tupple>();
		int n = grid.length;
		int m = grid[0].length;
		int[][] distance = new int[n][m];

		// fill array
		for (int[] arr : distance)
			Arrays.fill(arr, (int) 1e9);

		distance[source[0]][source[1]] = 0;
		q.add(new Tupple(0, source[0], source[1]));

		int[] dR = { -1, 0, 1, 0 };
		int[] dC = { 0, 1, 0, -1 };
		while (!q.isEmpty()) {
			Tupple it = q.poll();
			int dist = it.first;
			int r = it.second;
			int c = it.third;

			for (int i = 0; i < 4; i++) {
				int newR = r + dR[i];
				int newC = c + dC[i];

				// check for validity
				if (newR >= 0 && newR < n && newC >= 0 && newC < m && grid[newR][newC] == 1
						&& dist + 1 < distance[newR][newC]) {
					distance[newR][newC] = dist + 1;

					// if reach destination
					if (newR == destination[0] && newC == destination[1])
						return dist + 1;
					q.add(new Tupple(dist + 1, newR, newC));
				}
			}
		}
		return -1;
	}
}
