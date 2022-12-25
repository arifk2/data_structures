package com.rf.khan.api.coding.decoded;

import java.util.Arrays;

public class JobScheduleMinDifficulityLC1335 {

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] jobDifficulty = { 6, 5, 4, 3, 2, 1 };
		int d = 2;

		JobScheduleMinDifficulityLC1335 j = new JobScheduleMinDifficulityLC1335();
		System.out.println(j.minDifficulty(jobDifficulty, d));
	}

	/**
	 * @param jobDifficulty
	 * @param d
	 * @return
	 */
	public int minDifficulty(int[] jobDifficulty, int d) {
		// if the number of days is greater than array size.
		if (jobDifficulty.length < d)
			return -1;

		int[][] dp = new int[d + 1][jobDifficulty.length];
		for (int[] arr : dp)
			Arrays.fill(arr, -1);

		return dfs(jobDifficulty, dp, d, 0);

	}

	private int dfs(int[] jobDifficulty, int[][] dp, int d, int index) {
		// when number of days become one, then we need to get the max
		if (d == 1) {
			int max = 0;
			while (index < jobDifficulty.length) {
				max = Math.max(max, jobDifficulty[index++]);
			}
			return max;
		}

		if (dp[d][index] != -1)
			return dp[d][index];

		int leftMax = 0;

		int res = Integer.MAX_VALUE;
		for (int i = index; i < jobDifficulty.length - d + 1; i++) {
			leftMax = Math.max(leftMax, jobDifficulty[i]);
			res = Math.min(res, leftMax + dfs(jobDifficulty, dp, d - 1, i + 1));
		}

		return dp[d][index] = res;
	}
}
