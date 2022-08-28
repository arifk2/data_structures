package com.rf.khan.api.iq.dp;

/**
 * This class is created to get the minimum number square is required to create
 * a number
 * 
 * @author mkhan339
 *
 */
public class GetMinSquaresRecMemoization {

	public static int MinSquares(int n) {

		// return solveRecursion(n);

		int[] dp = new int[n + 1];
		java.util.Arrays.fill(dp, -1);

		return solveRecursionMemoization(n, dp);
	}

	/**
	 * Solve using recursion and memoization
	 * 
	 * @param n
	 * @param dp
	 * @return
	 */
	private static int solveRecursionMemoization(int n, int[] dp) {

		// base case
		if (n == 0)
			return 0;

		// Step 2:
		if (dp[n] != -1)
			return dp[n];

		int ans = n;
		for (int i = 1; i * i <= n; i++) {
			int temp = i * i;
			ans = Math.min(ans, 1 + solveRecursionMemoization(n - temp, dp));
		}

		// step 1: store the answer in the dp array
		dp[n] = ans;

		// Step 3 : return
		return dp[n];

	}

	/**
	 * This method is created to solve using recursion
	 * 
	 * @param n holds the information number that has t be created
	 * @return
	 */
	private static int solveRecursion(int n) {
		// base case
		if (n == 0)
			return 0;

		// max ans kya ho sakta hai, 1 se bana se answer
		int ans = n;
		for (int i = 1; i * i <= n; i++) {
			int temp = i * i;

			ans = Math.min(ans, 1 + solveRecursion(n - temp));
		}

		return ans;
	}

	/**
	 * Driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// System.out.println(s.MinSquares(100));
		System.out.println(MinSquares(6));
	}
}