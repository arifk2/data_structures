package com.rf.khan.api.iq.dp;

public class PaintAndFenceRecursionSpaceOptm {

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

		return solveRecursionMemoizationOptm(n, k);

	}

	/**
	 * This method is created to solve using memoization
	 * 
	 * @param n
	 * @param k
	 * @param dp
	 * @return
	 */
	private static int solveRecursionMemoizationOptm(int n, int k) {

		int prev2 = k;
		int prev1 = add(k, mul(k, k - 1));

		for (int i = 3; i <= n; i++) {
			// recursive call
			int same = mul(prev2, k - 1);
			int different = mul(prev1, k - 1);

			int ans = add(same, different);

			prev2 = prev1;
			prev1 = ans;
		}
		return prev1;

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
		int n = 3;
		int k = 2;
		System.out.println(numberOfWays(n, k));
	}
}
