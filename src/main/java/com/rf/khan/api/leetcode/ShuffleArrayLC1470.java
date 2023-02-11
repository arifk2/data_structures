package com.rf.khan.api.leetcode;

public class ShuffleArrayLC1470 {
	public int[] shuffle(int[] nums, int n) {
		int[] ans = new int[nums.length];
		int index = 0;

		for (int i = 0; i < nums.length / 2; i++) {
			int first = nums[i];
			ans[index++] = first;

			int second = nums[i + n];
			ans[index++] = second;
		}
		return ans;
	}
}
