package com.rf.khan.api.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLaddersLC909 {

	public static void main(String[] args) {
		int[][] board = { { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 },
				{ -1, 35, -1, -1, 13, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, 15, -1, -1, -1, -1 } };
		SnakesAndLaddersLC909 s = new SnakesAndLaddersLC909();
		System.out.println(s.snakesAndLadders(board));
	}

	/**
	 * Approach : BFS traversal
	 * 
	 * @param board
	 * @return
	 */
	public int snakesAndLadders(int[][] board) {
		int n = board.length;
		boolean[][] visited = new boolean[n][n];
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[n - 1][0] = true;
		int minSteps = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int currVal = q.poll();
				if (currVal == n * n)
					return minSteps;
				// to get the each dice values 1,2,3,4,5,6
				for (int diceValue = 1; diceValue <= 6; diceValue++) {
					if (diceValue + currVal > n * n)
						continue;
					// get the coordinates : main crust
					int pos[] = findCoordinates(diceValue + currVal, n);
					int row = pos[0];
					int col = pos[1];
					if (visited[row][col] == false) {
						visited[row][col] = true;
						if (board[row][col] == -1) {
							q.add(diceValue + currVal);
						} else {
							// dice or ladder
							q.add(board[row][col]);
						}
					}
				}
			}
			minSteps++;
		}
		return -1;
	}

	/**
	 * How to find the coordinates
	 * 
	 * @param currValue
	 * @param n
	 * @return
	 */
	private int[] findCoordinates(int currValue, int n) {
		int row = n - (currValue - 1) / n - 1;
		int col = (currValue - 1) % n;
		if (row % 2 == n % 2) {
			return new int[] { row, n - 1 - col };
		} else {
			return new int[] { row, col };
		}
	}
}
