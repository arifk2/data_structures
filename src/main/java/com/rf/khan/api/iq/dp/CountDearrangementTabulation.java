package com.rf.khan.api.iq.dp;

import java.util.Arrays;

public class CountDearrangementTabulation {
	static int MOD = 1000000007;

	/**
	 * Using recursion
	 * 
	 * @param n
	 * @return
	 */
	public static long countDerangements(int n) {

		return solveTabulation(n);
	}

	/**
	 * Solve using tabulation
	 * 
	 * @param n
	 * @return
	 */
	public static long solveTabulation(int n) {
		long[] dp = new long[n + 1];
		Arrays.fill(dp, 0);

		dp[1] = 0;
		dp[2] = 1;

		for (int i = 3; i <= n; i++) {
			long first = dp[i - 1] % MOD;
			long second = dp[i - 2] % MOD;

			long sum = (first + second) % MOD;

			long ans = ((i - 1) * sum) % MOD;
			dp[i] = ans;
		}
		return dp[n];
	}

	public static long solvespaceOpt(int n) {

		long prev2 = 0;
		long prev1 = 1;

		for (int i = 3; i <= n; i++) {
			long first = prev1 % MOD;
			long second = prev2 % MOD;

			long sum = (first + second) % MOD;

			long ans = ((i - 1) * sum) % MOD;

			prev2 = prev1;
			prev1 = ans;

		}
		return prev1;
	}

	/**
	 * Driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(countDerangements(6));
		System.out.println(solvespaceOpt(6));
	}
}
