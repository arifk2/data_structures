package com.rf.khan.api.iq.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumNonAdjMemoization {

	/**
	 * Driver method, where created dp array and give input to mem method
	 * 
	 * @param nums
	 * @return
	 */
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		int n = nums.size();

		// create dp array
		int[] dp = new int[n];
		Arrays.fill(dp, -1);

		int ans = solveMemoization(nums, n - 1, dp);
		return ans;
	}

	/**
	 * This method is created using memoization + recursion
	 * 
	 * @param nums
	 * @param n
	 * @param dp
	 * @return
	 */
	private static int solveMemoization(ArrayList<Integer> nums, int n, int[] dp) {
		// base case
		if (n == 0)
			return nums.get(0);
		if (n < 0)
			return 0;

		// base
		if (dp[n] != -1)
			return dp[n];

		int include = solveMemoization(nums, n - 2, dp) + nums.get(n);
		int exclude = solveMemoization(nums, n - 1, dp) + 0;

		dp[n] = Math.max(include, exclude);

		return dp[n];
	}

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
}
