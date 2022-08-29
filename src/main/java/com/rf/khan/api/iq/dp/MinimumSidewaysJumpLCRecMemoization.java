package com.rf.khan.api.iq.dp;

import java.util.Arrays;

/**
 * Frog is on lane 2
 * 
 * * A frog starts at point 0 in the second lane and wants to jump to point n
 * 
 * @author mkhan339
 *
 */
public class MinimumSidewaysJumpLCRecMemoization {
	public int minSideJumps(int[] obstacles) {

		int[][] dp = new int[4][obstacles.length];

		for (int[] arr : dp)
			Arrays.fill(arr, -1);
		// current position =0 and current lane is 2
		return solveUsingRecursionMem(obstacles, 0, 2, dp);
	}

	/**
	 * Solving using recursion + memoization
	 * 
	 * @param obstacles
	 * @param currPostion
	 * @param currLane
	 * @param dp
	 * @return
	 */
	private int solveUsingRecursionMem(int[] obstacles, int currPostion, int currLane, int[][] dp) {
		int n = obstacles.length - 1;

		// base case;
		if (currPostion == n)
			return 0;
		if (dp[currLane][currPostion] != -1)
			return dp[currLane][currPostion];

		if (obstacles[currPostion + 1] != currLane) {
			return solveUsingRecursionMem(obstacles, currPostion + 1, currLane, dp);
		} else {
			// sideways jump
			int ans = Integer.MAX_VALUE;
			// lane change
			for (int i = 1; i <= 3; i++) {
				if (currLane != i && obstacles[currPostion] != i)
					ans = Math.min(ans, 1 + solveUsingRecursionMem(obstacles, currPostion, i, dp));
			}

			dp[currLane][currPostion] = ans;
			return dp[currLane][currPostion];
		}
	}

	/**
	 * Driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] obstacle = { 0, 1, 2, 3 };
		MinimumSidewaysJumpLCRecMemoization m = new MinimumSidewaysJumpLCRecMemoization();
		System.out.println(m.minSideJumps(obstacle));
	}
}
