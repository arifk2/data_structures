package com.rf.khan.api.iq.dp;

import java.util.Arrays;

public class CutIntoSegmentMemoizationTab {
	public static int cutSegments(int n, int x, int y, int z) {
		// create a dp array of n+1 size
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);

		int ans = solveRecursionMemoization(n, x, y, z, dp);
		if (ans > 0)
			return ans;
		return 0;
	}

	/**
	 * Solved using recursion and memoization
	 * 
	 * @param n
	 * @param x
	 * @param y
	 * @param z
	 * @param dp
	 * @return
	 */
	public static int solveRecursionMemoization(int n, int x, int y, int z, int dp[]) {
		// base case
		if (n == 0)
			return 0;
		if (n < 0)
			return Integer.MIN_VALUE;
		if (dp[n] != -1)
			return dp[n];

		int aX = solveRecursionMemoization(n - x, x, y, z, dp) + 1;
		int aY = solveRecursionMemoization(n - y, x, y, z, dp) + 1;
		int aZ = solveRecursionMemoization(n - z, x, y, z, dp) + 1;

		dp[n] = Math.max(Math.max(aX, aY), aZ);
		return dp[n];
	}

	/**
	 * Solving Using tabulation in dp
	 * 
	 * @param n
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public static int solveTabulation(int n, int x, int y, int z) {
		int[] dp = new int[n + 1];
		// Arrays.fill(dp, Integer.MIN_VALUE);
		Arrays.fill(dp, -1);

		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			if (i - x >= 0 || dp[i] != -1)
				dp[i] = Math.max(dp[i], dp[i - x] + 1);

			if (i - y >= 0 || dp[i] != -1)
				dp[i] = Math.max(dp[i], dp[i - y] + 1);

			if (i - z >= 0 || dp[i] != -1)
				dp[i] = Math.max(dp[i], dp[i - z] + 1);
		}

		if (dp[n] < 0)
			return 0;

		return dp[n];

	}

	public static void main(String[] args) {
		System.out.println(cutSegments(25, 10, 5, 2));
		System.out.println(solveTabulation(25, 10, 5, 2));
	}
}