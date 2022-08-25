package com.rf.khan.api.iq.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumNonAdjRecursion {

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
		int n = nums.size();

		int ans = solveRecursion(nums, n - 1);
		return ans;
	}

	/**
	 * Solving using recursion
	 * 
	 * @param nums
	 * @param n
	 * @return
	 */
	private static int solveRecursion(ArrayList<Integer> nums, int n) {
		// base case
		if (n == 0)
			return nums.get(0);
		if (n < 0)
			return 0;

		int include = solveRecursion(nums, n - 2) + nums.get(n);
		int exclude = solveRecursion(nums, n - 1) + 0;

		return Math.max(include, exclude);
	}
}