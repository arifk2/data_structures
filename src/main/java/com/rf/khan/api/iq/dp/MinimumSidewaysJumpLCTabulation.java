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
public class MinimumSidewaysJumpLCTabulation {
	public int minSideJumps(int[] obstacles) {

		return solveUsingRecursionTabulation(obstacles);
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
	private int solveUsingRecursionTabulation(int[] obstacles) {
		int n = obstacles.length - 1;

		// step1: create dp array
		int[][] dp = new int[4][obstacles.length];
		for (int[] arr : dp)
			Arrays.fill(arr, 1000000000);

		// analyse base case and try to fill the dp array
		dp[0][n] = 0;
		dp[1][n] = 0;
		dp[2][n] = 0;
		dp[3][n] = 0;

		for (int currPosition = n - 1; currPosition >= 0; currPosition--) {
			for (int currLane = 1; currLane <= 3; currLane++) {

				if (obstacles[currPosition + 1] != currLane) {
					dp[currLane][currPosition] = dp[currLane][currPosition + 1];
				} else {
					// sideways jump
					int ans = Integer.MAX_VALUE;
					// lane change
					for (int i = 1; i <= 3; i++) {
						if (currLane != i && obstacles[currPosition] != i)
							ans = Math.min(ans, 1 + dp[i][currPosition + 1]);
					}
					dp[currLane][currPosition] = ans;
				}
			}
		}
		return Math.min(dp[2][0], Math.min(1 + dp[1][0], 1 + dp[3][0]));
	}

	/**
	 * Driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] obstacle = { 0, 1, 2, 3 };
		MinimumSidewaysJumpLCTabulation m = new MinimumSidewaysJumpLCTabulation();
		System.out.println(m.minSideJumps(obstacle));
	}
}
