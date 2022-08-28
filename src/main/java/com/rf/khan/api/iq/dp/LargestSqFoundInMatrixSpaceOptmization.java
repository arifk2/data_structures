package com.rf.khan.api.iq.dp;

import java.util.concurrent.atomic.AtomicInteger;

public class LargestSqFoundInMatrixSpaceOptmization {

	/**
	 * This is driver method
	 * 
	 * @param n
	 * @param m
	 * @param mat
	 * @return
	 */
	static int maxSquare(int n, int m, int mat[][]) {
		AtomicInteger maxi = new AtomicInteger(0);
		solveBySpaceOptimization(mat, maxi);
		return maxi.get();
	}

	/**
	 * Solving by tabulations
	 * 
	 * @param mat
	 * @return
	 */
	private static int solveBySpaceOptimization(int[][] mat, AtomicInteger maxi) {
		int row = mat.length;
		int col = mat[0].length;

		int[] curr = new int[col + 1];
		int[] next = new int[col + 1];

		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--) {

				int right = curr[j + 1];
				int diagonal = next[j + 1];
				int down = next[j];

				if (mat[i][j] == 1) {
					curr[j] = 1 + Math.min(right, Math.min(diagonal, down));
					maxi.set(Math.max(curr[j], maxi.get()));
				} else {
					curr[j] = 0;
				}
			}
			next = curr;
		}
		return next[0];
	}

	public static void main(String[] args) {

		int[][] mat = { { 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 1, 0 }, { 0, 0, 1, 1, 1, 0 },
				{ 1, 1, 1, 1, 1, 1 } };
		int n = 5;
		int m = 6; 
		System.out.println(maxSquare(n, m, mat));
	}
}
