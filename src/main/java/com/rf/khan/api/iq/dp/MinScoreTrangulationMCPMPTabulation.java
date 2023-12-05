package com.rf.khan.api.iq.dp;

import java.util.Arrays;

public class MinScoreTrangulationMCPMPTabulation {

	public int minScoreTriangulation(int[] values) {
		return solveTabulation(values);
	}

	/**
	 * This method is created to solve the problem using recursion
	 * 
	 * @param values
	 * @return
	 */
	private int solveTabulation(int[] values) {
		int n = values.length;
		int[][] dp = new int[n][n];
		for (int[] arr : dp)
			Arrays.fill(arr, 0);
		for (int i = n - 1; i >= 0; i--) {
			// j = i+2, because we start from i+1, then there is two point a, b which is not
			// possible to create triangle
			for (int j = i + 2; j < n; j++) {
				int ans = Integer.MAX_VALUE;
				for (int k = i + 1; k < j; k++) {
					ans = Math.min(ans, values[i] * values[j] * values[k] + dp[i][k] + dp[k][j]);
				}
				dp[i][j] = ans;
			}
		}

		return dp[0][n - 1];
	}

	public static void main(String[] args) {
		int[] values = { 1, 2, 3 };
		MinScoreTrangulationMCPMPTabulation m = new MinScoreTrangulationMCPMPTabulation();
		System.out.println(m.minScoreTriangulation(values));
	}
}
