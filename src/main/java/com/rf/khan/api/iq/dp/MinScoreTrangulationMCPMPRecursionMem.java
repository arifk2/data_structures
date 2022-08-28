package com.rf.khan.api.iq.dp;

import org.bouncycastle.util.Arrays;

public class MinScoreTrangulationMCPMPRecursionMem {

	/**
	 * Driver method to get the solution using recursion and memoization
	 * 
	 * @param values
	 * @return
	 */
	public int minScoreTriangulation(int[] values) {
		int n = values.length;

		int[][] dp = new int[n][n];
		for (int[] arr : dp)
			Arrays.fill(arr, -1);

		return solveRecursionMem(values, 0, n - 1, dp);
	}

	/**
	 * This method is created to solve the problem using recursion
	 * 
	 * @param values
	 * @param i
	 * @param n
	 * @return
	 */
	private int solveRecursionMem(int[] values, int i, int j, int[][] dp) {
		// base case
		if (i + 1 == j)
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		int ans = Integer.MAX_VALUE;

		// to determine the kth value
		for (int k = i + 1; k < j; k++) {
			ans = Math.min(ans, values[i] * values[j] * values[k] + solveRecursionMem(values, i, k, dp)
					+ solveRecursionMem(values, k, j, dp));
		}
		dp[i][j] = ans;

		return dp[i][j];
	}

	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] values = { 1, 3, 1, 4, 1, 5 };
		MinScoreTrangulationMCPMPRecursionMem m = new MinScoreTrangulationMCPMPRecursionMem();
		System.out.println(m.minScoreTriangulation(values));
	}
}
