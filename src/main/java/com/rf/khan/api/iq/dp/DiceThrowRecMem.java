package com.rf.khan.api.iq.dp;

import org.bouncycastle.util.Arrays;

/**
 * This class is create to get the number of the distinct throw of dice to make
 * the target.
 * 
 * @author mkhan339
 *
 */
public class DiceThrowRecMem {

	static long noOfWays(int M, int N, int X) {

		long[][] dp = new long[N + 1][X + 1];

		for (long[] arr : dp)
			Arrays.fill(arr, -1);

		return solveUsingRecursionMem(N, M, X, dp);
	}

	/**
	 * Soling using recursion
	 * 
	 * @param dices  number of dices
	 * @param faces  number of faces
	 * @param target target value
	 * @return
	 */
	private static long solveUsingRecursionMem(int dices, int faces, int target, long[][] dp) {

		// base case
		if (target < 0)
			return 0;

		if (dices == 0 && target != 0)
			return 0;

		if (dices != 0 && target == 0)
			return 0;

		if (target == 0 && dices == 0)
			return 1;

		if (dp[dices][target] != -1)
			return dp[dices][target];

		long ans = 0;
		for (int i = 1; i <= faces; i++) {
			ans = ans + solveUsingRecursionMem(dices - 1, faces, target - i, dp);
		}

		return dp[dices][target] = ans;
	}

	public static void main(String[] args) {
		int M = 6, N = 3, X = 12;
		System.out.println(noOfWays(M, N, X));
	}
}
