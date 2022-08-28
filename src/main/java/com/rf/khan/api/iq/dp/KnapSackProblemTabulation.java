package com.rf.khan.api.iq.dp;

public class KnapSackProblemTabulation {

	static int knapsack(int[] weight, int[] value, int n, int capacity) {

		return solveTabulation(weight, value, n, capacity);
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
	private static int solveTabulation(int[] weight, int[] value, int n, int capacity) {
		int[][] dp = new int[n][capacity + 1];

		// analyze base case
		for (int w = weight[0]; w <= capacity; w++) {
			if (weight[0] <= capacity) {
				dp[0][w] = value[0];
			} else {
				dp[0][w] = 0;
			}
		}

		// recursive call-> index capacity change
		for (int index = 1; index < n; index++) {
			for (int w = 0; w <= capacity; w++) {
				int include = 0;

				if (weight[index] <= w)
					include = value[index] + dp[index - 1][w - weight[index]];

				int exclude = 0 + dp[index - 1][w];

				dp[index][w] = Math.max(include, exclude);

			}
		}
		return dp[n - 1][capacity];
	}

	/**
	 * Driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] weight = { 1, 2, 4, 5 };
		int[] value = { 5, 4, 8, 6 };
		int n = 4;
		int maxWeight = 5;
		System.out.println(knapsack(weight, value, n, maxWeight));
	}
}
