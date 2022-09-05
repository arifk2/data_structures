package com.rf.khan.api.iq.dp;

import java.util.Arrays;

public class GuessNumberHigherOrLowerLC375RecMem {

	/**
	 * This method is created to get the money amount
	 * 
	 * @param n holds the information of the number
	 * @return minimum money
	 */
	public int getMoneyAmount(int n) {
		int[][] dp = new int[n + 1][n + 1];

		for (int[] arr : dp)
			Arrays.fill(arr, -1);

		return solveRecursionMem(1, n, dp);
	}

	/**
	 * his method is created to solve using recursion +Memoization
	 * 
	 * @param start holds the information of the start
	 * @param end   holds the information of the end
	 * @return
	 */
	private int solveRecursionMem(int start, int end, int[][] dp) {
		if (start >= end)
			return 0;

		if (dp[start][end] != -1)
			return dp[start][end];

		int maxi = Integer.MAX_VALUE;
		for (int i = start; i <= end; i++) {
			maxi = Math.min(maxi, i + Math.max(solveRecursionMem(start, i - 1, dp), solveRecursionMem(i + 1, end, dp)));
		}

		return dp[start][end] = maxi;
	}

	/**
	 * This is a driver maain method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		GuessNumberHigherOrLowerLC375RecMem g = new GuessNumberHigherOrLowerLC375RecMem();
		int n = 10;
		System.out.println(g.getMoneyAmount(n));
	}
}
