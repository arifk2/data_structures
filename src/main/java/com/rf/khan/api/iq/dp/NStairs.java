package com.rf.khan.api.iq.dp;

import org.bouncycastle.util.Arrays;

public class NStairs {

	public static void main(String[] args) {
		countDistinctWayToClimbStair(4);
	}

	public static void countDistinctWayToClimbStair(int nStairs) {
		System.out.println(solveRecursion(nStairs + 1));
		/*************************************************/
		
		int[] dp = new int[nStairs + 1];
		Arrays.fill(dp, -1);
		System.out.println(solveMemoization(nStairs, dp));
		
		/*************************************************/
		System.out.println(solveMemoryOpt(nStairs));

	}

	/**
	 * Using Recursion
	 * 
	 * @param nStairs
	 * @param i
	 * @return
	 */
	private static long solveRecursion(long n) {
		// base case
		if (n <= 1) {
			return n;
		}

		return solveRecursion(n - 1) + solveRecursion(n - 2);
	}

	/**
	 * This method is created for the dp with memoization
	 * 
	 * @param n
	 * @param dp
	 * @return
	 */
	private static int solveMemoization(int n, int[] dp) {
		if (n <= 1) {
			return dp[n] = 1;
		}

		if (dp[n] != -1) {
			return dp[n];
		}

		return dp[n] = solveMemoization(n - 1, dp) + solveMemoization(n - 2, dp);
	}

	private static int solveMemoryOpt(int n) {
		int prev2 = 1;
		int prev1 = 1;

		for (int i = 2; i <= n; i++) {
			int currrent = prev2 + prev1;
			prev2 = prev1;
			prev1 = currrent;
		}
		return prev1;
	}

}
