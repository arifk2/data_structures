package com.rf.khan.api.iq.recursion;

import java.util.ArrayList;
import java.util.List;

public final class PowerSetLC78 {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> ans = subsets(nums);
		System.out.println(ans);
		System.out.println(ans.size());

	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> output = new ArrayList<>();
		int index = 0;

		solve(nums, output, index, ans);

		return ans;
	}

	private static void solve(int[] nums, List<Integer> output, int index, List<List<Integer>> ans) {

		// base case
		if (index >= nums.length) {
			ans.add(new ArrayList<>(output));
			return;
		}

		// exclude
		solve(nums, output, index + 1, ans);

		// include
		int element = nums[index];
		output.add(element);

		solve(nums, output, index + 1, ans);
		output.remove(output.size() - 1);

	}
}
