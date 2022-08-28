package com.rf.khan.api.iq.dp;

public class KnapSackProblemOptmization2 {

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

		int[] curr = new int[capacity + 1];

		// analyze base case
		for (int w = weight[0]; w <= capacity; w++) {
			if (weight[0] <= capacity)
				curr[w] = value[0];
			else
				curr[w] = 0;

		}

		// recursive call-> index capacity change
		for (int index = 1; index < n; index++) {
			// right to left
			for (int w = capacity; w >= 0; w--) {
				int include = 0;

				if (weight[index] <= w)
					include = value[index] + curr[w - weight[index]];

				int exclude = 0 + curr[w];

				curr[w] = Math.max(include, exclude);
			}
		}
		return curr[capacity];
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
