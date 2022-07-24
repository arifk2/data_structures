package com.rf.khan.api.iq.slidingwindow;

public class MaxSubArray {

	public static void main(String[] args) {
		int[] inputArray = { 1, 2, 3, 4, 3, 6 };
		int k = 3;

		System.out.println(maxSlidingWindow(inputArray, k));
	}

	public static int maxSlidingWindow(int[] nums, int k) {

		int start = 0;
		int end = 0;
		int sum = 0;
		int max = Integer.MIN_VALUE;

		while (end < nums.length - 1) {
			if ((end - start + 1) <= k) {
				sum = sum + nums[end];
				end++;

			} else {
				max = Math.max(max, sum);
				start++;
				sum = sum - nums[start] + nums[end];
			}
		}
		return max;
	}
}
