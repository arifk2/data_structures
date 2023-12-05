package com.rf.khan.api.iq.dp;

import java.util.Arrays;

public class CountDearrangementRecMem {

	/**
	 * Using recursion
	 * 
	 * @param n
	 * @return
	 */
	public static long countDerangements(int n) {
		// base case
		if (n == 1)
			return 0;

		if (n == 2)
			return 1;

		long ans = (n - 1) * (countDerangements(n - 1) + countDerangements(n - 2));
		return ans;
	}

	/**
	 * Recursion + memoization
	 * 
	 * @param n
	 * @return
	 */
	public static long countDerangementsRecMem(int n) {
		// create dp array
		long dp[] = new long[n + 1];
		Arrays.fill(dp, -1);

		return solveRecursionMemoization(dp, n);
	}

	static int MOD = 1000000007;

	/**
	 * Solving using recursion and memoization
	 * 
	 * @param dp
	 * @param n
	 * @return
	 */
	private static long solveRecursionMemoization(long[] dp, int n) {
		// base case
		if (n == 0)
			return 0;

		if (n == 2)
			return 1;

		if (dp[n] != -1)
			return dp[n];

		if (n != -1)
			dp[n] = (n - 1) * (solveRecursionMemoization(dp, n - 1)) + (solveRecursionMemoization(dp, n - 2));

		return dp[n];
	}

	/**
	 * Driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(countDerangements(3));
		//System.out.println(countDerangementsRecMem(3));
	}
}
