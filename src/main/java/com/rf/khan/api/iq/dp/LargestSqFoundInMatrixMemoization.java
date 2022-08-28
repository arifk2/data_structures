package com.rf.khan.api.iq.dp;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class LargestSqFoundInMatrixMemoization {

	/**
	 * Driver method
	 * 
	 * @param n
	 * @param m
	 * @param mat
	 * @return
	 */
	static int maxSquare(int n, int m, int mat[][]) {
		AtomicInteger maxi = new AtomicInteger(0);
		int[][] dp = new int[n][m];
		for (int[] row : dp)
			Arrays.fill(row, -1);

		solveByRecursionMemoization(mat, 0, 0, maxi, dp);
		return maxi.get();
	}

	/**
	 * Solve by recursion
	 * 
	 * @param mat
	 * @param i
	 * @param j
	 * @param maxi
	 */
	private static int solveByRecursionMemoization(int[][] mat, int i, int j, AtomicInteger maxi, int[][] dp) {

		// base case i and j should not go outside of the array
		if (i >= mat.length || j >= mat[0].length)
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		int right = solveByRecursionMemoization(mat, i, j + 1, maxi, dp);
		int diagonal = solveByRecursionMemoization(mat, i + 1, j + 1, maxi, dp);
		int down = solveByRecursionMemoization(mat, i + 1, j, maxi, dp);

		if (mat[i][j] == 1) {
			dp[i][j] = 1 + Math.min(right, Math.min(diagonal, down));
			maxi.set(Math.max(dp[i][j], maxi.get()));
			return dp[i][j];
		} else {
			return dp[i][j] = 0;
		}
	}

	public static void main(String[] args) {

		int[][] mat = { { 1, 1 }, { 1, 1 } };
		int n = 2;
		int m = 2;
		System.out.println(maxSquare(n, m, mat));
	}
}
