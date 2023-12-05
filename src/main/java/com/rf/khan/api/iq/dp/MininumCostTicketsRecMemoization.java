package com.rf.khan.api.iq.dp;

import java.util.Arrays;

public class MininumCostTicketsRecMemoization {

	public static int minimumCoins(int n, int[] days, int[] cost) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		return solveRecursionMemoization(n, days, cost, 0, dp);
	}

	/**
	 * Solving using recursion
	 * 
	 * @param n
	 * @param totalDays
	 * @param cost
	 * @param index
	 * @return
	 */
	private static int solveRecursionMemoization(int totalDays, int[] days, int[] cost, int index, int[] dp) {

		// base case
		// if the number of the days is increase to current day number
		if (index >= totalDays)
			return 0;

		if (dp[index] != -1)
			return dp[index];

		// option 1: 1 day pass
		int option1 = cost[0] + solveRecursionMemoization(totalDays, days, cost, index + 1, dp);

		// option 2: 7 day pass
		// days[index] + 7;
		// 7 days ka pass lene ke baad kis din pe pahuch sakte ho

		int i;
		for (i = index; i < totalDays && days[i] < days[index] + 7; i++)
			;

		int option2 = cost[1] + solveRecursionMemoization(totalDays, days, cost, i, dp);

		// option3: 30 days pass

		for (i = index; i < totalDays && days[i] < days[index] + 30; i++)
			;
		int option3 = cost[2] + solveRecursionMemoization(totalDays, days, cost, i, dp);

		dp[index] = Math.min(option1, Math.min(option2, option3));

		return dp[index];
	}

	public static void main(String[] args) {

		int[] days = { 1, 4, 6, 7, 8, 20 };
		int[] cost = { 2, 7, 15 };
		int n = days.length;

		System.out.println(minimumCoins(n, days, cost));
	}
}
