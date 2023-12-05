package com.rf.khan.api.iq.dp;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class LargestSqFoundInMatrixTabulation {

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
		solveByTabulation(mat, maxi);
		return maxi.get();
	}

	/**
	 * Solving by tabulations
	 * 
	 * @param mat
	 * @return
	 */
	private static int solveByTabulation(int[][] mat, AtomicInteger maxi) {
		int row = mat.length;
		int col = mat[0].length;
		int[][] dp = new int[row + 1][col + 1];
		for (int[] arr : dp)
			Arrays.fill(arr, 0);

		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--) {

				int right = dp[i][j + 1];
				int diagonal = dp[i + 1][j + 1];
				int down = dp[i + 1][j];

				if (mat[i][j] == 1) {
					dp[i][j] = 1 + Math.min(right, Math.min(diagonal, down));
					maxi.set(Math.max(dp[i][j], maxi.get()));
				} else {
					dp[i][j] = 0;
				}

			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {

		int[][] mat = { { 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 1, 0 }, { 0, 0, 1, 1, 1, 0 },
				{ 1, 1, 1, 1, 1, 1 } };
		int n = 5;
		int m = 6;
		System.out.println(maxSquare(n, m, mat));
	}
}
