package com.rf.khan.api.iq.dp;

import java.util.Arrays;

public class ReducingDishesTabulation {

	/**
	 * Solving using tabulation
	 * 
	 * @param satisfaction
	 * @return
	 */
	public int maxSatisfaction(int[] satisfaction) {

		return solveUsingtabulation(satisfaction);
	}

	/**
	 * Solving using tabulation
	 * 
	 * @param satisfaction
	 * @param index
	 * @param time
	 * @return
	 */
	private int solveUsingtabulation(int[] satisfaction) {
		int n = satisfaction.length;
		int[][] dp = new int[n + 1][n + 1];

		for (int index = n - 1; index >= 0; index--) {
			for (int time = index; time >= 0; time--) {
				int include = satisfaction[index] * (time + 1) + dp[index + 1][time + 1];
				int exclude = 0 + dp[index + 1][time];

				dp[index][time] = Math.max(include, exclude);
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		int[] satisfaction = { 4, 3, 2 };
		Arrays.sort(satisfaction);
		ReducingDishesTabulation r = new ReducingDishesTabulation();
		System.out.println(r.maxSatisfaction(satisfaction));
	}
}
