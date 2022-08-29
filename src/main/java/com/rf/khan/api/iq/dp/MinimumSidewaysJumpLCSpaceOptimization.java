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
public class MinimumSidewaysJumpLCSpaceOptimization {
	public int minSideJumps(int[] obstacles) {

		return solveUsingRecursionSpaceOptiomization(obstacles);
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
	private int solveUsingRecursionSpaceOptiomization(int[] obstacles) {
		int n = obstacles.length - 1;

		int[] curr = new int[4];
		Arrays.fill(curr, Integer.MAX_VALUE);

		int[] next = new int[4];
		Arrays.fill(next, Integer.MAX_VALUE);

		// analyse base case and try to fill the dp array
		next[0] = 0;
		next[1] = 0;
		next[2] = 0;
		next[3] = 0;

		for (int currPosition = n - 1; currPosition >= 0; currPosition--) {
			for (int currLane = 1; currLane <= 3; currLane++) {

				if (obstacles[currPosition + 1] != currLane) {
					curr[currLane] = next[currLane];
				} else {
					// sideways jump
					int ans = Integer.MAX_VALUE;
					// lane change
					for (int i = 1; i <= 3; i++) {
						if (currLane != i && obstacles[currPosition] != i)
							ans = Math.min(ans, 1 + next[i]);
					}
					curr[currLane] = ans;
				}
			}
			next = curr;
		}
		return Math.min(next[2], Math.min(1 + next[1], 1 + next[3]));
	}

	/**
	 * Driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] obstacle = { 0, 1, 2, 3 };
		MinimumSidewaysJumpLCSpaceOptimization m = new MinimumSidewaysJumpLCSpaceOptimization();
		System.out.println(m.minSideJumps(obstacle));
	}
}
