package com.rf.khan.api.iq.dp;

import org.bouncycastle.util.Arrays;

public class LongestIncreasingSubsequenceRecMemoization {
	// Function to find length of longest increasing subsequence.
	static int longestSubsequence(int size, int a[]) {
		int[][] dp = new int[size][size + 1];
		for (int[] arr : dp)
			Arrays.fill(arr, -1);

		return solveUsingRecursionMemoization(a, 0, -1, dp);
	}

	/**
	 * Solving using recursion + memoization
	 * 
	 * @param a
	 * @param current
	 * @param previous
	 * @return
	 */
	private static int solveUsingRecursionMemoization(int[] a, int current, int previous, int[][] dp) {
		if (current == a.length)
			return 0;

		if (dp[current][previous + 1] != -1)
			return dp[current][previous + 1];
		
		int include = 0;
		if (previous == -1 || a[current] > a[previous])
			include = 1 + solveUsingRecursionMemoization(a, current + 1, current, dp);

		int exclude = 0 + solveUsingRecursionMemoization(a, current + 1, previous, dp);

		dp[current][previous + 1] = Math.max(include, exclude);

		return dp[current][previous + 1];
	}

	public static void main(String[] args) {
		int[] a = { 5, 8, 3, 7, 9, 1 };
		int size = a.length;
		System.out.println(longestSubsequence(size, a));
	}
}
