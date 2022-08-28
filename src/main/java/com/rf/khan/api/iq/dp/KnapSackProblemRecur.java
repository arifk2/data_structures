package com.rf.khan.api.iq.dp;

public class KnapSackProblemRecur {

	static int knapsack(int[] weight, int[] value, int n, int capacity) {
		return solveRecursive(weight, value, n - 1, capacity);
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
	private static int solveRecursive(int[] weight, int[] value, int index, int capacity) {
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

		// recursive relation
		int include = 0;

		if (weight[index] <= capacity)
			include = value[index] + solveRecursive(weight, value, index - 1, capacity - weight[index]);

		int exclude = 0 + solveRecursive(weight, value, index - 1, capacity);

		int ans = Math.max(include, exclude);

		return ans;
	}

	public static void main(String[] args) {
		int[] weight = { 1, 2, 4, 5 };
		int[] value = { 5, 4, 8, 6 };
		int n = 4;
		int maxWeight = 5;
		System.out.println(knapsack(weight, value, n, maxWeight));
	}
}
