package com.rf.khan.api.iq.graph.striver;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1
 */
class Tupple {
	int first;
	int second;
	int third;

	public Tupple(int first, int second, int third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}

}

public class G36ShortestDistanceBinaryMaze {

	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] source = { 0, 1 };
		int[] destination = { 2, 2 };

		int[][] grid = { { 1, 1, 1, 1 },
						 { 1, 1, 0, 1 }, 
						 { 1, 1, 1, 1 }, 
						 { 1, 1, 0, 0 }, 
						 { 1, 0, 0, 1 } };

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

		// Edge case: when source is destination
		if (source[0] == destination[0] && source[1] == destination[1])
			return 0;

		// Create a queue for storing cells with their distances from source
		// in the form {dist,{cell coordinates pair}}.
		Queue<Tupple> q = new LinkedList<Tupple>();
		int n = grid.length;
		int m = grid[0].length;

		// Create a distance matrix with initially all the cells marked as
		// unvisited and the source cell as 0.
		int[][] distance = new int[n][m];

		for (int[] arr : distance)
			Arrays.fill(arr, (int) 1e9);

		// update start distance with zero
		distance[source[0]][source[1]] = 0;

		// add in queue
		q.add(new Tupple(0, source[0], source[1]));

		// The following delta rows and delts columns array are created such that
		// each index represents each adjacent node that a cell may have
		// in a direction.
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		// Iterate through the maze by popping the elements out of the queue
		// and pushing whenever a shorter distance to a cell is found.
		while (!q.isEmpty()) {
			Tupple it = q.poll();
			int dist = it.first;
			int r = it.second;
			int c = it.third;

			// Through this loop, we check the 4 direction adjacent nodes
			// for a shorter path to destination.
			for (int i = 0; i < 4; i++) {
				int newR = r + dr[i];
				int newC = c + dc[i];

				// Checking the validity of the cell and updating if dist is shorter.
				if (newR >= 0 && newR < n && newC >= 0 && newC < m && grid[newR][newC] == 1
						&& dist + 1 < distance[newR][newC]) {
					distance[newR][newC] = dist + 1;

					// Return the distance until the point when
					// we encounter the destination cell.
					if (newR == destination[0] && newC == destination[1])
						return dist + 1;

					// add into queue
					q.add(new Tupple(dist + 1, newR, newC));
				}
			}
		}
		// If no path is found from source to destination.
		return -1;
	}
}
