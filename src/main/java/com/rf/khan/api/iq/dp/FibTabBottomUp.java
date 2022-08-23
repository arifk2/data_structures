package com.rf.khan.api.iq.dp;

public class FibTabBottomUp {

	public static void main(String[] args) {
		System.out.println(fibSeriesUsingDpTabulationBottonUp(6));
	}

	/**
	 * Bottom up approach
	 * 
	 * @param n
	 * 
	 *          * Analyze the base case and insert the values in the dp array and
	 *          then base on the for loop inert the element in the dp array base on
	 *          the recursive call modification
	 * @return
	 */
	public static int fibSeriesUsingDpTabulationBottonUp(int n) {
		// Step1: create array of n size
		int[] dp = new int[n + 1];

		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
}