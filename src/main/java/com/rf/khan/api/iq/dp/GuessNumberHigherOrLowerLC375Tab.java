package com.rf.khan.api.iq.dp;

import java.util.Arrays;

public class GuessNumberHigherOrLowerLC375Tab {

	/**
	 * This method is created to get the money amount
	 * 
	 * @param n holds the information of the number
	 * @return minimum money
	 */
	public int getMoneyAmount(int n) {
		return solveRecursionTab(n);
	}

	/**
	 * his method is created to solve using recursion +Memoization
	 * 
	 * @param start holds the information of the start
	 * @param end   holds the information of the end
	 * @return
	 */
	private int solveRecursionTab(int n) {

		int[][] dp = new int[n + 2][n + 2];

		for (int start = n; start >= 1; start--) {
			for (int end = start; end <= n; end++) {
				if (start == end)
					continue;
				else {
					int maxi = Integer.MAX_VALUE;
					for (int i = start; i <= end; i++) {
						maxi = Math.min(maxi, i + Math.max(dp[start][i - 1], dp[i + 1][end]));
					}
					dp[start][end] = maxi;
				}
			}
		}
		return dp[1][n];
	}

	/**
	 * This is a driver maain method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		GuessNumberHigherOrLowerLC375Tab g = new GuessNumberHigherOrLowerLC375Tab();
		int n = 10;
		System.out.println(g.getMoneyAmount(n));
	}
}
