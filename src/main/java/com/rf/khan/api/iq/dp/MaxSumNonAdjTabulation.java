package com.rf.khan.api.iq.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumNonAdjTabulation {

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

		int ans = solveTab(nums);
		return ans;
	}

	private static int solveTab(ArrayList<Integer> nums) {
		int n = nums.size();
		// create dp array
		int[] dp = new int[n];
		Arrays.fill(dp, 0);

		// base case analyze
		dp[0] = nums.get(0);

		for (int i = 1; i < n; i++) {

			int include = dp[i - 2] + nums.get(i);
			int exclude = dp[i - 1] + 0;
			dp[i] = Math.max(include, exclude);
		}

		return dp[n - 1];
	}
}
