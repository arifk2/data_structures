package com.rf.khan.api.iq.dp;

import org.bouncycastle.util.Arrays;

public class MinCostClimStairs {

	public static void main(String[] args) {
		int[] in = new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		System.out.println(minCostClimbingStairs2(in));
		System.out.println(solveBottomUp(in, in.length));
		System.out.println(solveSpcOpt(in, in.length));
	}

	public static int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
		int ans = Math.min(solve(cost, n - 1), solve(cost, n - 2));
		return ans;
	}

	/**
	 * Recursive
	 * 
	 * @param cost
	 * @param n
	 * @return
	 */
	private static int solve(int[] cost, int n) {
		// base case
		if (n == 0)
			return cost[0];
		if (n == 1)
			return cost[1];

		int ans = cost[n] + Math.min(solve(cost, n - 1), solve(cost, n - 2));
		return ans;
	}

	/**
	 * Using memoization
	 * 
	 * @param cost
	 * @return
	 */
	public static int minCostClimbingStairs2(int[] cost) {
		int n = cost.length;

		// Step 1 dp array create ans initialize
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);

		int ans = Math.min(solve2(dp, cost, n - 1), solve2(dp, cost, n - 2));
		return ans;
	}

	/**
	 * Recursion Memoization
	 * 
	 * @param dp
	 * @param cost
	 * @param n
	 * @return
	 */
	private static int solve2(int[] dp, int[] cost, int n) {
		// base case
		if (n == 0)
			return cost[0];

		if (n == 1)
			return cost[1];

		if (dp[n] != -1)
			return dp[n];

		// Step 2
		dp[n] = cost[n] + Math.min(solve2(dp, cost, n - 1), solve2(dp, cost, n - 2));
		return dp[n];
	}

	/**
	 * Tabulation
	 * 
	 * @param cost
	 * @param n
	 * @return
	 */
	private static int solveBottomUp(int[] cost, int n) {
		// 1 create dp
		int[] dp = new int[n + 1];

		// 2 base case analyze
		dp[0] = cost[0];
		dp[1] = cost[1];

		// remaining form 2 to n-1
		for (int i = 2; i < n; i++) {
			dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
		}

		return Math.min(dp[n - 1], dp[n - 2]);
	}

	/**
	 * Space Optimization
	 * 
	 * @param cost
	 * @param n
	 * @return
	 */
	private static int solveSpcOpt(int[] cost, int n) {
		int prev2 = cost[0];
		int prev1 = cost[1];

		for (int i = 2; i < n; i++) {
			int current = cost[i] + Math.min(prev1, prev2);
			prev2 = prev1;
			prev1 = current;
		}

		return Math.min(prev2, prev1);
	}

}
