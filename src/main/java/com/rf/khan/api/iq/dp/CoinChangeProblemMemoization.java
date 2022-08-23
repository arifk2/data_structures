package com.rf.khan.api.iq.dp;

import java.util.Arrays;

public class CoinChangeProblemMemoization {

	public static int minimumElements(int num[], int x) {
		// Step 1: create dp array and initialize
		int[] dp = new int[x + 1];
		Arrays.fill(dp, -1);

		int ans = solveMemoization(num, x, dp);
		if (ans != Integer.MAX_VALUE)
			return ans;

		return -1;
	}

	/**
	 * This method is created to solve the problem using dp memoization plus
	 * recursion
	 * 
	 * @param num
	 * @param amount
	 * @param dp
	 * @return
	 */
	private static int solveMemoization(int[] num, int amount, int[] dp) {
		// base case
		if (amount == 0)
			return 0;
		if (amount < 0)
			return Integer.MAX_VALUE;

		int mini = Integer.MAX_VALUE;

		// dp base case
		if (dp[amount] != -1)
			return dp[amount];

		for (int i = 0; i < num.length; i++) {
			int ans = solveMemoization(num, amount - num[i], dp);
			if (ans != Integer.MAX_VALUE)
				mini = Math.min(mini, ans + 1);
		}

		dp[amount] = mini;
		return mini;
	}

	public static void main(String[] args) {

		int num[] = { 1, 2, 3 };
		int x = 7;

		System.out.println(minimumElements(num, x));

	}
}
