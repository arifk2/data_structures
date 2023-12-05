package com.rf.khan.api.iq.dp;

/**
 * This class is create to get the number of the distinct throw of dice to make
 * the target.
 * 
 * @author mkhan339
 *
 */
public class DiceThrowTabulation {

	static long noOfWays(int M, int N, int X) {

		return solveUsingTabulation(N, M, X);
	}

	/**
	 * Soling using recursion
	 * 
	 * @param d number of dices
	 * @param f number of faces
	 * @param t target value
	 * @return
	 */
	private static long solveUsingTabulation(int d, int f, int t) {

		long[][] dp = new long[d + 1][t + 1];

		// analyze base case
		dp[0][0] = 1;

		for (int dice = 1; dice <= d; dice++) {
			for (int target = 1; target <= t; target++) {
				long ans = 0;
				for (int i = 1; i <= f; i++) {
					if ((target - i) >= 0)
						ans = ans + dp[dice - 1][target - i];
				}
				dp[dice][target] = ans;
			}
		}

		return dp[d][t];
	}

	/**
	 * Driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int M = 6, N = 3, X = 12;
		System.out.println(noOfWays(M, N, X));
	}
}
