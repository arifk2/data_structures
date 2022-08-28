package com.rf.khan.api.iq.dp;

public class CombinationsIVTabulation {
	public static int findWays(int num[], int tar) {
		return solveRecursionTabulation(num, tar);
	}

	/**
	 * Solving using tabulation - space optimization is not possible
	 * 
	 * @param num
	 * @param tar
	 * @return
	 */
	public static int solveRecursionTabulation(int[] num, int tar) {
		int[] dp = new int[tar + 1];
		// base
//		if (tar < 0)
//			return 0;
//		if (tar == 0)
//			return 1;
//
//		if (dp[tar] != -1)
//			return dp[tar];

		dp[0] = 1;

		// traversing from target 1 to tar
		for (int i = 1; i <= tar; i++) {
			// traverse on num
			for (int j = 0; j < num.length; j++) {
				if (i - num[j] >= 0)
					dp[i] += dp[i - num[j]];
			}

		}
		return dp[tar];
	}

	public static void main(String[] args) {
		int[] num = { 1, 2, 5 };
		int tar = 5;
		System.out.println(findWays(num, tar));
	}
}