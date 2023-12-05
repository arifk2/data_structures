package com.rf.khan.api.iq.dp;

import java.util.Arrays;

public class PaintAndFenceRecursionTabulation {

	private static int MOD = 1000000007;

	/**
	 * This method is to get the number of ways
	 * 
	 * @param n total number of post
	 * @param k total number of color
	 * @return return total number of ways
	 */
	public static int numberOfWays(int n, int k) {
		if (n == 1)
			return k;
		return solveRecursionTabulation(n, k);
	}

	/**
	 * This method is created to solve using tabulation
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	private static int solveRecursionTabulation(int n, int k) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, 0);

		// base case
		dp[1] = k;
		dp[2] = add(k, mul(k, k - 1));

		// recursive call

		for (int i = 3; i <= n; i++) {
			int same = mul(dp[i - 2], k - 1);
			int different = mul(dp[i - 1], k - 1);

			dp[i] = add(same, different);
		}
		return dp[n];

	}

	/**
	 * add utility method to handle modulus
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int add(int a, int b) {
		return (a % MOD + b % MOD) % MOD;
	}

	/**
	 * multiply utility method to handle modulus
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int mul(int a, int b) {
		return (int) ((a % MOD * 1L * b % MOD) % MOD);
	}

	public static void main(String[] args) {
		int n = 1;
		int k = 1;
		System.out.println(numberOfWays(n, k));
	}
}
