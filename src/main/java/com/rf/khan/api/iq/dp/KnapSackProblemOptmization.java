package com.rf.khan.api.iq.dp;

public class KnapSackProblemOptmization {

	static int knapsack(int[] weight, int[] value, int n, int capacity) {

		return solveOptimization(weight, value, n, capacity);
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
	private static int solveOptimization(int[] weight, int[] value, int n, int capacity) {

		int[] prev = new int[capacity + 1];
		int[] curr = new int[capacity + 1];

		// analyze base case
		for (int w = weight[0]; w <= capacity; w++) {
			if (weight[0] <= capacity)
				prev[w] = value[0];
			else
				prev[w] = 0;

		}

		// recursive call-> index capacity change
		for (int index = 1; index < n; index++) {
			// left to right
			for (int w = 0; w <= capacity; w++) {
				int include = 0;

				if (weight[index] <= w)
					include = value[index] + prev[w - weight[index]];

				int exclude = 0 + prev[w];

				curr[w] = Math.max(include, exclude);
			}
			prev = curr;
		}
		return prev[capacity];
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
