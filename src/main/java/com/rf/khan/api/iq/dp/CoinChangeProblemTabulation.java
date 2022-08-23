package com.rf.khan.api.iq.dp;

import java.util.Arrays;

public class CoinChangeProblemTabulation {

	public static int minimumElements(int num[], int x) {

		return solveTab(num, x);
	}

	/**
	 * Using tabulation
	 * 
	 * @param num
	 * @param amount
	 * @return
	 */
	public static int solveTab(int[] num, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		// base case analyze
		dp[0] = 0;

		for (int i = 1; i <= amount; i++) {
			// i am trying to solve every amount figure from 1 to amount
			for (int j = 0; j < num.length; j++) {

				if (i - num[j] >= 0 && dp[i - num[j]] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], 1 + dp[i - num[j]]);
				}
			}
		}

		if (dp[amount] == Integer.MAX_VALUE)
			return -1;

		return dp[amount];
	}

	/**
	 * Driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int num[] = { 1, 2, 3 };
		int x = 7;

		System.out.println(minimumElements(num, x));

	}
}
