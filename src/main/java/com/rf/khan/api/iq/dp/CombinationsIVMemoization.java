package com.rf.khan.api.iq.dp;

import java.util.Arrays;

public class CombinationsIVMemoization {
	public static int findWays(int num[], int tar) {
		int[] dp = new int[tar + 1];
		Arrays.fill(dp, -1);
		return solveRecursionRecMem(num, tar, dp);
	}

	public static int solveRecursionRecMem(int[] num, int tar, int[] dp) {
		// base
		if (tar < 0)
			return 0;
		if (tar == 0)
			return 1;

		if (dp[tar] != -1)
			return dp[tar];

		int ans = 0;
		for (int i = 0; i < num.length; i++) {
			ans += solveRecursionRecMem(num, tar - num[i], dp);
		}
		dp[tar] = ans;

		return dp[tar];
	}
}