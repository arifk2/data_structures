package com.rf.khan.api.iq.dp;

/**
 * This class is created to get the minimum number square is required to create
 * a number
 * 
 * @author mkhan339
 *
 */
public class GetMinSquaresTabulation {

	public static int MinSquares(int n) {
		return solveTabulation(n);
	}

	/**
	 * This method is created to solve using tabulation
	 * 
	 * @param n total target
	 * @return
	 */
	private static int solveTabulation(int n) {

		int[] dp = new int[n + 1];
		java.util.Arrays.fill(dp, Integer.MAX_VALUE);

		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j * j <= n; j++) {
				int temp = j * j;
				if ((i - temp) >= 0)
					dp[i] = Math.min(dp[i], 1 + dp[i - temp]);
			}
		}

		return dp[n];

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