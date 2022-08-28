package com.rf.khan.api.iq.dp;

import java.util.Arrays;

public class KnapSackProblemRecurMemoization {

	static int knapsack(int[] weight, int[] value, int n, int capacity) {
		// index, capacity
		int[][] dp = new int[n][capacity + 1];

		/*
		 * for (int[] row : dp) { Arrays.fill(row, -1); }
		 */
		Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));

		return solveRecursiveMemoization(weight, value, n - 1, capacity, dp);
	}

	/**
	 * Traveling right to left
	 * 
	 * (n-1) to 0
	 * 
	 * @param index
	 * @param weight
	 * @param value
	 * @param n
	 * @param capacity
	 * @return
	 */
	private static int solveRecursiveMemoization(int[] weight, int[] value, int index, int capacity, int[][] dp) {
		// base case
		// if only 1 item to steal, then just compare its weight with the snapsack
		// capacity.
		if (index == 0) {
			// check for the capacity
			if (weight[0] <= capacity) {
				return value[0];
			} else {
				return 0;
			}
		}
		if (dp[index][capacity] != -1)
			return dp[index][capacity];

		// recursive relation
		int include = 0;

		if (weight[index] <= capacity)
			include = value[index] + solveRecursiveMemoization(weight, value, index - 1, capacity - weight[index], dp);

		int exclude = 0 + solveRecursiveMemoization(weight, value, index - 1, capacity, dp);

		dp[index][capacity] = Math.max(include, exclude);

		return dp[index][capacity];
	}

	public static void main(String[] args) {
		int[] weight = { 1, 2, 4, 5 };
		int[] value = { 5, 4, 8, 6 };
		int n = 4;
		int maxWeight = 5;
		System.out.println(knapsack(weight, value, n, maxWeight));
	}
}
