package com.rf.khan.api.iq.dp;

public class PaintAndFenceRecursion {

	private static int MOD = 1000000007;

	/**
	 * This method is to get the number of ways
	 * 
	 * @param n total number of post
	 * @param k total number of color
	 * @return return total number of ways
	 */
	public static int numberOfWays(int n, int k) {
		return solveRecursion(n, k);
	}

	private static int solveRecursion(int n, int k) {

		// base case
		// if number of post is 1, then ans will be total number of color
		if (n == 1)
			return k;

		if (n == 2)
			return add(k, mul(k, k - 1));

		// recursive call
		int same = mul(solveRecursion(n - 2, k), k - 1);
		int different = mul(solveRecursion(n - 1, k), k - 1);

		int ans = add(same, different);

		return ans;

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
		return (int) ((a % MOD * 1L* b % MOD)  % MOD);
	}

	public static void main(String[] args) {
		int n = 3;
		int k = 2;
		System.out.println(numberOfWays(n, k));
	}
}
