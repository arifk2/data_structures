package com.rf.khan.api.iq.dp;

import org.bouncycastle.util.Arrays;

public class MininumCostTicketsTabulation {

	public static int minimumCoins(int n, int[] days, int[] cost) {
		return solveTabulation(n, days, cost);
	}

	/**
	 * Solving using Tabulation, bottom up approach
	 * 
	 * @param n
	 * @param n
	 * @param cost
	 * @param index
	 * @return
	 */
	private static int solveTabulation(int n, int[] days, int[] cost) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		// step 1: analyze the base case
		dp[n] = 0;

		for (int k = n - 1; k >= 0; k--) {
			int option1 = cost[0] + dp[k + 1];

			// option 2: 7 day pass
			// days[index] + 7;
			// 7 days ka pass lene ke baad kis din pe pahuch sakte ho

			int i;
			for (i = k; i < n && days[i] < days[k] + 7; i++)
				;
			int option2 = cost[1] + dp[i];

			// option3: 30 days pass
			for (i = k; i < n && days[i] < days[k] + 30; i++)
				;
			int option3 = cost[2] + dp[i];

			dp[k] = Math.min(option1, Math.min(option2, option3));

		}

		return dp[0];
	}

	public static void main(String[] args) {

		int[] days = { 1, 4, 6, 7, 8, 20 };
		int[] cost = { 2, 7, 15 };
		int n = days.length;

		System.out.println(minimumCoins(n, days, cost));
	}
}
