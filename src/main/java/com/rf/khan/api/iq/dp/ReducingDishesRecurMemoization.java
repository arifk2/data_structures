package com.rf.khan.api.iq.dp;

import java.util.Arrays;

public class ReducingDishesRecurMemoization {

	/**
	 * Solving using recursion
	 * 
	 * @param satisfaction
	 * @return
	 */
	public int maxSatisfaction(int[] satisfaction) {
		int n = satisfaction.length;
		int[][] dp = new int[n + 1][n + 1];
		for (int[] arr : dp)
			Arrays.fill(arr, -1);

		return solveUsingRecursionMemoization(satisfaction, 0, 0, dp);
	}

	/**
	 * Solving using recursion
	 * 
	 * @param satisfaction
	 * @param index
	 * @param time
	 * @return
	 */
	private int solveUsingRecursionMemoization(int[] satisfaction, int index, int time, int[][] dp) {
		// base case
		if (index == satisfaction.length)
			return 0;

		if (dp[index][time] != -1)
			return dp[index][time];

		int include = satisfaction[index] * (time + 1)
				+ solveUsingRecursionMemoization(satisfaction, index + 1, time + 1, dp);
		int exclude = 0 + solveUsingRecursionMemoization(satisfaction, index + 1, time, dp);

		dp[index][time] = Math.max(include, exclude);
		return dp[index][time];
	}

	public static void main(String[] args) {
		int[] satisfaction = { 4, 3, 2 };
		Arrays.sort(satisfaction);
		ReducingDishesRecurMemoization r = new ReducingDishesRecurMemoization();
		System.out.println(r.maxSatisfaction(satisfaction));
	}
}
