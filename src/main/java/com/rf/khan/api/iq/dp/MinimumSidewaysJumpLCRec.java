package com.rf.khan.api.iq.dp;

/**
 * Frog is on lane 2
 * 
 * * A frog starts at point 0 in the second lane and wants to jump to point n
 * 
 * @author mkhan339
 *
 */
public class MinimumSidewaysJumpLCRec {
	public int minSideJumps(int[] obstacles) {
		// current position =0 and current lane is 2
		return solveUsingRecursion(obstacles, 0, 2);
	}

	private int solveUsingRecursion(int[] obstacles, int currPostion, int currLane) {
		int n = obstacles.length - 1;

		// base case;
		if (currPostion == n)
			return 0;

		if (obstacles[currPostion + 1] != currLane) {
			return solveUsingRecursion(obstacles, currPostion + 1, currLane);
		} else {
			// sideways jump
			int ans = Integer.MAX_VALUE;
			// lane change
			for (int i = 1; i <= 3; i++) {
				if (currLane != i && obstacles[currPostion] != i)
					ans = Math.min(ans, 1 + solveUsingRecursion(obstacles, currPostion, i));
			}
			return ans;
		}
	}

	/**
	 * Driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] obstacle = { 0, 1, 2, 3 };
		MinimumSidewaysJumpLCRec m = new MinimumSidewaysJumpLCRec();
		System.out.println(m.minSideJumps(obstacle));
	}
}
