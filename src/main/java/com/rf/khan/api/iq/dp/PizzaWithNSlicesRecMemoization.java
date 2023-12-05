package com.rf.khan.api.iq.dp;

import java.util.Arrays;

public class PizzaWithNSlicesRecMemoization {

	/**
	 * Solving using recursion
	 * 
	 * @param slices
	 * @return
	 */
	public int maxSizeSlices(int[] slices) {
		int k = slices.length;

		int[][] dp = new int[k][k];
		for (int[] arr : dp)
			Arrays.fill(arr, -1);
		
		int[][] dp1 = new int[k][k];
		for (int[] arr : dp1)
			Arrays.fill(arr, -1);

		int case1 = solveUsingRecursionMemoization(0, k - 2, slices, k / 3, dp);
		int case2 = solveUsingRecursionMemoization(1, k - 1, slices, k / 3, dp1);

		return Math.max(case1, case2);
	}

	/**
	 * Solving using recursion + memoization
	 * 
	 * @param index
	 * @param slices
	 * @param n
	 * @return
	 */

	private int solveUsingRecursionMemoization(int index, int endIndex, int[] slices, int n, int[][] dp) {
		// base
		if (n == 0 || index > endIndex)
			return 0;

		if (dp[index][n] != -1)
			return dp[index][n];

		int take = slices[index] + solveUsingRecursionMemoization(index + 2, endIndex, slices, n - 1, dp);
		int nottake = 0 + solveUsingRecursionMemoization(index + 1, endIndex, slices, n, dp);

		return dp[index][n] = Math.max(take, nottake);
	}

	/**
	 * This is a main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] slices = { 9, 5, 1, 7, 8, 4, 4, 5, 5, 8, 7, 7 };
		PizzaWithNSlicesRecMemoization p = new PizzaWithNSlicesRecMemoization();
		System.out.println(p.maxSizeSlices(slices));

	}
}
