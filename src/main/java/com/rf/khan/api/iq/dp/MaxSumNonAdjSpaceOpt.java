package com.rf.khan.api.iq.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumNonAdjSpaceOpt {

	/**
	 * Driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(new Integer[] { 1, 2, 4 }));
		ArrayList<Integer> nums1 = new ArrayList<>(Arrays.asList(new Integer[] { 2, 1, 4, 9 }));

		System.out.println(maximumNonAdjacentSum(nums));
		System.out.println(maximumNonAdjacentSum(nums1));
	}

	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {

		int ans = solveSpaceOpt(nums);
		return ans;
	}

	/**
	 * Space Optimization in dp
	 * 
	 * @param nums
	 * @return
	 */
	private static int solveSpaceOpt(ArrayList<Integer> nums) {
		int n = nums.size();
		int prev2 = 0;
		int prev1 = nums.get(0);

		for (int i = 1; i < n; i++) {
			int incl = prev2 + nums.get(i);
			int excl = prev1 + 0;
			int ans = Math.max(incl, excl);

			// shift
			prev2 = prev1;
			prev1 = ans;
		}
		return prev1;
	}
}
